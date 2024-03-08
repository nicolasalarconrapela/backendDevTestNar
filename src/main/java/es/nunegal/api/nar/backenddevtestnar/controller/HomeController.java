package es.nunegal.api.nar.backenddevtestnar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase RestController
 */
@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
}