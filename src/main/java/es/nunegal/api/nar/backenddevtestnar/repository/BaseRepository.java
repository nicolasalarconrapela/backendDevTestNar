package es.nunegal.api.nar.backenddevtestnar.repository;

import es.nunegal.api.nar.backenddevtestnar.model.Product;

import java.util.List;

public interface BaseRepository {

    Product getProductFluxById(String productId);

    List<String> getSimilarProductFluxIds(String productId);
}
