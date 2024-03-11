package es.nunegal.api.nar.backenddevtestnar.util;

import org.springframework.http.HttpStatus;


/**
 * Constantes de la aplicación
 */
public class Constants {

    public static final int BAD_REQUEST_STATUS_CODE_VALUE = HttpStatus.BAD_REQUEST.value();
    public static final String BAD_REQUEST_STATUS_CODE_REASON = HttpStatus.BAD_REQUEST.getReasonPhrase();

}