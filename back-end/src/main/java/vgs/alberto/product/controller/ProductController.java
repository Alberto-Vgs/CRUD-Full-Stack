package vgs.alberto.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vgs.alberto.product.entity.Product;
import vgs.alberto.product.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product saveProduct(@Validated @RequestBody Product product)
    {
        return productService.saveProduct(product);
    }

    @GetMapping("/product")
    public List<Product> fetchProductList()
    {
        return productService.fetchProductList();
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Long productId)
    {
        return productService.updateProduct(product, productId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteProductById(@PathVariable("id") Long productId)
    {
        productService.deleteProductById(productId);
        return "Deleted Successfully";
    }
}
