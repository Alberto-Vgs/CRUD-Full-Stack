package vgs.alberto.product.service;

import vgs.alberto.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> fetchProductList();

    Product getProduct(Long productId);

    Product updateProduct(Product product, Long productId);

    void deleteProductById(Long productId);
}
