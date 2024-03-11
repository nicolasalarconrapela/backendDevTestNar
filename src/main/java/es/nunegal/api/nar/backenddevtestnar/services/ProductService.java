package es.nunegal.api.nar.backenddevtestnar.services;

import es.nunegal.api.nar.backenddevtestnar.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getSimilarProductbyProductId(int productId);

}