package es.nunegal.api.nar.backenddevtestnar.services;

import es.nunegal.api.nar.backenddevtestnar.model.Product;
import es.nunegal.api.nar.backenddevtestnar.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio de {@link Product
 */
@Log4j2
@Service
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Obtiene la lista de los productos por el ID
     *
     * @param productId Id de {@link Product}
     * @return Lista de {@link Product}
     */
    @Override
    public List<Product> getSimilarProductbyId(String productId) {

        if (productId != null) {
            log.info("ℹ️ Inicio 02 | Búsqueda de producto con id : {}", productId);
            List<String> similarProductsIds = productRepository.getSimilarProductFluxIds(productId);
            log.info("ℹ️ Obtenido");

        } else {
            log.error("❌ El id es cero");
            return null;
        }

        List<String> similarProductsIds = productRepository.getSimilarProductFluxIds(productId);

        log.info(CollectionUtils.isEmpty(similarProductsIds) ?
                "ℹ️ No hemos encontrado productos con ID : " + productId :
                "ℹ️ Hemos encontrado productos con ID : " + productId + " - " + similarProductsIds);
        return similarProductsIds.stream()
                .map(productRepository::getProductFluxById)
                .collect(Collectors.toList());
    }
}
