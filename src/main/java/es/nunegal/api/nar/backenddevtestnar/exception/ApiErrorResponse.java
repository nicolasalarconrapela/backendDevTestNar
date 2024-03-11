package es.nunegal.api.nar.backenddevtestnar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Respuesta personalizada para Error de API
 */
@Getter
@AllArgsConstructor
public class ApiErrorResponse {

    private final int statusCode;
    private final String statusReason;
    private final String personalMessage;

}