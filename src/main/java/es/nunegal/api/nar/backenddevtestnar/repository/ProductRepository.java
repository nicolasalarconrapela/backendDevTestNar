package es.nunegal.api.nar.backenddevtestnar.repository;

import es.nunegal.api.nar.backenddevtestnar.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Log4j2
@AllArgsConstructor
@Repository
public class ProductRepository implements BaseRepository {

    private final RestTemplate restTemplate;
    @Override
    public Product getProductFluxById(String productId) {

        String url = "http://localhost:3001/product/{productId}"; // properties
        Map<String, String> params = new HashMap<>();
        params.put("productId", String.valueOf(productId));
        Product response = restTemplate.getForObject(url, Product.class, params);
        return response;
    }

    @Override
    public List<String> getSimilarProductFluxIds(String productId) {

        log.debug("ℹ️ 03 Inicio");
        String url = "http://localhost:3001/product/{productId}"; // properties
        Map<String, String> params = new HashMap<>();
        params.put("productId", String.valueOf(productId));
        String[] response = restTemplate.getForObject(url + "/similarids", String[].class, params);
        if (response == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(response);
    }
}

