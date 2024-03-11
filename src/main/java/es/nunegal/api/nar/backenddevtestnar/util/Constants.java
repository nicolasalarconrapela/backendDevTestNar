package es.nunegal.api.nar.backenddevtestnar.util;

import org.springframework.http.HttpStatus;


/**
 * Constantes de la aplicación
 */
public class Constants {

    // INTERNAL_SERVER_ERROR
    public static final HttpStatus INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;
    public static final int INTERNAL_SERVER_ERROR_STATUS_CODE_VALUE = HttpStatus.INTERNAL_SERVER_ERROR.value();
    public static final String INTERNAL_SERVER_ERROR_STATUS_CODE_REASON = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();


    // BAD_REQUEST - 400
    public static final int BAD_REQUEST_STATUS_CODE_VALUE = HttpStatus.BAD_REQUEST.value();
    public static final String BAD_REQUEST_STATUS_CODE_REASON = HttpStatus.BAD_REQUEST.getReasonPhrase();
    public static final HttpStatus STATUS_OK = HttpStatus.OK;

}