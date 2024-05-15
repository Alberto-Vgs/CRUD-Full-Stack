package vgs.alberto.product.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

    private Long key;
    private String name;
    private String price;
    private Long quantity;
    private Boolean status;

}
