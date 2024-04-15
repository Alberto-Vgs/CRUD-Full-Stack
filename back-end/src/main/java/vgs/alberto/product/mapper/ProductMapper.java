package vgs.alberto.product.mapper;

import vgs.alberto.product.dto.ProductDTO;
import vgs.alberto.product.entity.Product;

public class ProductMapper {

    public static Product mapToProduct(ProductDTO dto) {
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setProductPrice(dto.getProductPrice());
        product.setProductQuantity(dto.getProductQuantity());
        return product;
    }
}
