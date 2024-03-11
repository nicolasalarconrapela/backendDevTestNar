package es.nunegal.api.nar.backenddevtestnar.services;

import es.nunegal.api.nar.backenddevtestnar.model.Product;

import java.util.List;

/**
 * Interfaz del Service de {@link Product}
 */
public interface ProductService {

    List<Product> getSimilarProductbyId(String productId);

}