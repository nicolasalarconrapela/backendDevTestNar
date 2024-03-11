package es.nunegal.api.nar.backenddevtestnar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase controlador de Home
 */
@RestController
public class HomeController {

    /**
     * Controlador inicial de la aplicación
     *
     * @return String
     */
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
}