package es.nunegal.api.nar.backenddevtestnar.model;

import lombok.*;

/**
 * Clase para modelo: <code></code>Product</code>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    /**
     * Id del {@link Product}
     */
    private int id;

    /**
     * Nombre del {@link Product}
     */
    private String name;

    /**
     * Precio del {@link Product}
     */
    private double price;

    /**
     * Disponibilidad del {@link Product}
     */
    private boolean availability;

}
