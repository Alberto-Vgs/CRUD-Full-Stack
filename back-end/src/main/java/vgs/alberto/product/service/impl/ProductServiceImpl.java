package vgs.alberto.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vgs.alberto.product.entity.Product;
import vgs.alberto.product.repository.ProductRepository;
import vgs.alberto.product.service.ProductService;

import java.util.ArrayList;
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
    public List<Product> saveProducts(List<Product> products) {
        return (List<Product>) productRepository.saveAll(products);
    }

    @Override
    public List<Product> fetchProductList() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProduct(Long productId) {
        Optional<Product> proFond = productRepository.findById(productId);
        if (proFond.isPresent()) return proFond.get();
        else throw new RuntimeException("Product not found for id: " + productId);
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        Optional<Product> proDB = productRepository.findById(productId);

        if (proDB.isPresent()) {
            Product savePro = proDB.get();

            if (Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName()))
                savePro.setProductName(product.getProductName());

            if (Objects.nonNull(product.getProductPrice()) && !"".equalsIgnoreCase(product.getProductPrice()))
                savePro.setProductPrice(product.getProductPrice());

            if (Objects.nonNull(product.getProductQuantity()))
                savePro.setProductQuantity(product.getProductQuantity());

            return  productRepository.save(savePro);
        } else {
            throw new RuntimeException("Product not found for id: " + productId);
        }
    }

    public List<Product> updateProducts(List<Product> products){
        List<Product> productList = new ArrayList<>();
        products.forEach(product -> productList.add(
                updateProduct(product, product.getProductId())
        ));
        return productList;
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
}