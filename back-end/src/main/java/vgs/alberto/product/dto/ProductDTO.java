package vgs.alberto.product.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

    private Long productId;
    private String productName;
    private String productPrice;
    private Long productQuantity;

}
