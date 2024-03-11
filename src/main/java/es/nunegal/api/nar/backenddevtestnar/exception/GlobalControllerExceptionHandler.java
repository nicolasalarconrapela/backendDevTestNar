package es.nunegal.api.nar.backenddevtestnar.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static es.nunegal.api.nar.backenddevtestnar.util.Constants.*;

/**
 * {@link ControllerAdvice}
 */
@Log4j2
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * Control de excepción del tipo {@link MethodArgumentTypeMismatchException}
     *
     * @param matEx {@link MethodArgumentTypeMismatchException}
     * @return Mensaje de error
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException matEx) {

        String paramName = matEx.getParameter().getParameterName();
        Object paramValue = matEx.getValue();
        String personalMssg = getPersonalMssg(matEx, paramName, paramValue);

        log.error(personalMssg);

        ApiErrorResponse errorResponse = new ApiErrorResponse(BAD_REQUEST_STATUS_CODE_VALUE, BAD_REQUEST_STATUS_CODE_REASON, personalMssg);
        log.error(errorResponse);

        return ResponseEntity.badRequest().body(errorResponse);
    }

    /**
     * Control de excepción del tipo {@link RestClientException}
     *
     * @param ex {@link RestClientException}
     * @return Mensaje de error
     */
    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<ApiErrorResponse> handleRestClientException(RestClientException ex) {

        String errorMessage = "Error al comunicarse con un servicio externo.";
        log.error("❌ " + errorMessage, ex);

        ApiErrorResponse errorResponse = new ApiErrorResponse(INTERNAL_SERVER_ERROR_STATUS_CODE_VALUE, INTERNAL_SERVER_ERROR_STATUS_CODE_REASON, errorMessage);

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiErrorResponse> nullPointerException(RestClientException ex) {

        String errorMessage = "❌ Error interno de la aplicación.";
        log.error("❌ " + errorMessage, ex);

        ApiErrorResponse errorResponse = new ApiErrorResponse(INTERNAL_SERVER_ERROR_STATUS_CODE_VALUE, INTERNAL_SERVER_ERROR_STATUS_CODE_REASON, errorMessage);

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorResponse);
    }


    /**
     * Mensaje a partir de los parámetros
     *
     * @param matEx      {@link MethodArgumentTypeMismatchException}
     * @param paramName  Nombre del parámetro
     * @param paramValue Valor del parámetro
     * @return Mensaje personalizado para enviar a la API
     */
    private static String getPersonalMssg(MethodArgumentTypeMismatchException matEx, String paramName, Object paramValue) {
        log.debug("paramName - {} | paramValue - {} ", paramName, paramValue);
        Class<?> expectedType = matEx.getRequiredType();

        String personalMssg;
        assert expectedType != null;

        if (expectedType.equals(Integer.class)) {
            personalMssg = String.format("❌ El parámetro '%s' debe ser un número entero. Se ha recibido '%s'.", paramName, paramValue);
        } else {
            personalMssg = String.format("❌ Se ha producido un error al procesar el parámetro '%s' (esperado: %s, recibido: %s).", paramName, expectedType.getSimpleName(), paramValue);
        }
        return personalMssg;
    }

}