package es.nunegal.api.nar.backenddevtestnar.repository;

import es.nunegal.api.nar.backenddevtestnar.model.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import static es.nunegal.api.nar.backenddevtestnar.util.Constants.*;

@Log4j2
//@AllArgsConstructor
@Repository
public class ProductRepository implements BaseRepository {

    private final RestTemplate restTemplate;

    public ProductRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${url.flux}")
    private String urlFlux;

    @Value("${url.flux.endpoint.product}")
    private String urlFluxEndPointProduct;

    @Value("${url.flux.endpoint.productbyid}")
    private String urlFluxEndPointProductById;

    @Value("${url.flux.endpoint.SimilarId}")
    private String urlFluxEndPointSimilarId;

    @Override
    public Product getProductFluxById(String productId) {
        log.info("📋 04 Inicio");

        String url = urlFlux + urlFluxEndPointProduct + urlFluxEndPointProductById;
        log.info("📋 url : {}", url);

        Map<String, String> params = new HashMap<>();
        params.put("productId", String.valueOf(productId));
        return restTemplate.getForObject(url, Product.class, params);
    }

    @Override
    public List<String> getSimilarProductFluxIds(String productId) {
        log.info("📋 03 Inicio");

        String url = urlFlux + urlFluxEndPointProduct + urlFluxEndPointSimilarId;
        log.info("📋 url : {}", url);


        List<String> similarIds = new ArrayList<>();

        ResponseEntity<String[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String[].class, productId);

        HttpStatusCode statusCode = responseEntity.getStatusCode();
        log.info("📋 statusCode : {}", statusCode);

        if (statusCode == STATUS_OK) {
            String[] response = responseEntity.getBody();
            if (response != null) {
                similarIds = Arrays.asList(response);
                log.info("📋 response : {}", Arrays.toString(response));
            } else {
                log.error("❌  El response viene a null");
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 - Not Found");
            }
        }
        return similarIds;
    }

}