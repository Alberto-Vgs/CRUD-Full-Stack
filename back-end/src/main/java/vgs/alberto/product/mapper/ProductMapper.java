package vgs.alberto.product.mapper;

import vgs.alberto.product.dto.ProductDTO;
import vgs.alberto.product.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product mapToProduct(ProductDTO dto) {
        Product product = new Product();
        product.setProductId(dto.getKey());
        product.setProductName(dto.getName());
        product.setProductPrice(dto.getPrice());
        product.setProductQuantity(dto.getQuantity());
        product.setProductStatus(dto.getStatus());
        return product;
    }

    public static ProductDTO mapToDTO(Product prd) {
        ProductDTO dto = new ProductDTO();
        dto.setKey(prd.getProductId());
        dto.setName(prd.getProductName());
        dto.setPrice(prd.getProductPrice());
        dto.setQuantity(prd.getProductQuantity());
        dto.setStatus(prd.getProductStatus());
        return dto;
    }

    public static List<Product> productList(List<ProductDTO> productsDTO){
        List<Product> productList = new ArrayList<>();
        productsDTO.forEach(product -> productList.add(mapToProduct(product)));
        return productList;
    }

    public static List<ProductDTO> dtoList(List<Product> products){
        List<ProductDTO> dtoList = new ArrayList<>();
        products.forEach(product -> dtoList.add(mapToDTO(product)));
        return dtoList;
    }
}
