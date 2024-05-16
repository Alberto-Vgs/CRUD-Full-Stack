package vgs.alberto.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    private String productPrice;

    private Long productQuantity;

    private Boolean productStatus;

    @PrePersist
    public void setDefaultPrice() {
        if (productPrice == null) productPrice = "0.0";

        if (productQuantity == null) productQuantity = 0L;

        if (productStatus == null) productStatus = true;
    }

}
