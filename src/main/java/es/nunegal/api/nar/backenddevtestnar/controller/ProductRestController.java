package es.nunegal.api.nar.backenddevtestnar.controller;

import es.nunegal.api.nar.backenddevtestnar.model.Product;
import es.nunegal.api.nar.backenddevtestnar.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controlador de {@link Product}
 */
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("${path.api}") // APi/V1
public class ProductRestController {

    private final ProductService productService;

    /**
     * Obtención de productos ({@link Product}) similares por ID de producto
     *
     * @param productId Id de {@link Product}
     * @return Lista de productos
     */
    @GetMapping(value = "${path.product}/{productId}/similar")
    public ResponseEntity<List<Product>> getSimilarProductbyProductId(@PathVariable("productId") Integer productId) {

        List<Product> productList = productService.getSimilarProductbyProductId(productId);

        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.getSimilarProductbyProductId(productId));
        } catch (Exception e) {
            log.error("❌ Se ha producido un error : {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}