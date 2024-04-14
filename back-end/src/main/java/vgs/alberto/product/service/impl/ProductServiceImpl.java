package vgs.alberto.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vgs.alberto.product.entity.Product;
import vgs.alberto.product.repository.ProductRepository;
import vgs.alberto.product.service.ProductService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProductList() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        Product proDB = productRepository.findById(productId);

        if (Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName())){
            proDB.setProductName(product.getProductName());
        }
        if (Objects.nonNull(product.getProductPrice()) && !"".equalsIgnoreCase(product.getProductPrice())){
            proDB.setProductPrice(product.getProductPrice());
        }
        if (Objects.nonNull(product.getProductQuantity())){
            proDB.setProductQuantity(product.getProductQuantity());
        }

        return  productRepository.save(proDB);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
}
