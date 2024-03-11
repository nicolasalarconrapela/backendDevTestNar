package es.nunegal.api.nar.backenddevtestnar.repository;

import es.nunegal.api.nar.backenddevtestnar.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static es.nunegal.api.nar.backenddevtestnar.util.Constants.STATUS_OK;

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
        log.info("📋 03 Inicio");

        // TODO : Usar properties
        String url = "http://localhost:3001/product/{productId}/similarids";

        List<String> similarIds = new ArrayList<>();

        try {
            ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(url, String[].class, productId);

            HttpStatusCode statusCode = responseEntity.getStatusCode();
            log.info("📋 statusCode : {}", statusCode);

            if (statusCode == STATUS_OK) {
                String[] response = responseEntity.getBody();
                if (response != null) {
                    similarIds = Arrays.asList(response);
                    log.info("📋 response : {}", Arrays.toString(response));
                } else {
                    log.error("❌  El response viene a null");
                    throw new NullPointerException("❌ El response viene a null");
                }
            } else {
                // TODO
//                log.warn("No se pudieron recuperar identificadores de flujo de productos similares para productId : {}", productId);
//                log.error("Error al recuperar identificadores de flujo de productos similares para productId : {}", productId);
//                throw new ProductNotFoundException("ldksmañl");
            }
        } catch (RestClientException e) {
            log.error("❌ Se ha producido un error:\n" + e);
            throw new RestClientException("❌ Error obteniendo IDs similares - id : " + productId, e);
        }

        return similarIds;
    }

}