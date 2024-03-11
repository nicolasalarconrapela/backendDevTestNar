package es.nunegal.api.nar.backenddevtestnar.services;

import es.nunegal.api.nar.backenddevtestnar.model.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de {@link Product
 */
@Log4j2
@Service
public class ProductServiceImpl implements ProductService {
    
    /**
     * Obtiene la lista de los productos por el ID
     *
     * @param productId Id de {@link Product}
     * @return Lista de {@link Product}
     */
    @Override
    public List<Product> getSimilarProductbyProductId(int productId) {

        if (productId != 0) {
            log.debug("ℹ️ Inicio | Búsqueda de producto con id : {}", productId);
            return new ArrayList<>();
        } else {
            log.error("❌ El id es cero");
            return null;
        }

    }
}
