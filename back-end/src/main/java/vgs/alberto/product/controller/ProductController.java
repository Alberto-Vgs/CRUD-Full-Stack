package vgs.alberto.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vgs.alberto.product.dto.ProductDTO;
import vgs.alberto.product.dto.ResponseDTO;
import vgs.alberto.product.entity.Product;
import vgs.alberto.product.mapper.ProductMapper;
import vgs.alberto.product.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    private List<Product> productList(List<ProductDTO> productsDTO){
        List<Product> productList = new ArrayList<>();
        productsDTO.forEach(product -> productList.add(ProductMapper.mapToProduct(product)));
        return productList;
    }

    @PostMapping("/product")
    public ResponseDTO<Product> saveProduct(@Validated @RequestBody ProductDTO productDTO)
    {
        return new ResponseDTO<Product>(
                201, "CREATED", productService.saveProduct(ProductMapper.mapToProduct(productDTO))
        );
    }

    @PostMapping("/products")
    public ResponseDTO<List<Product>> saveProducts(@Validated @RequestBody List<ProductDTO> productsDTO)
    {
        return new ResponseDTO<List<Product>>(
                201, "CREATED", productService.saveProducts(productList(productsDTO))
        );
    }

    @GetMapping("/product")
    public ResponseDTO<List<Product>> fetchProductList()
    {
        return new ResponseDTO<List<Product>>(
                200, "FOUND", productService.fetchProductList()
        );
    }

    @GetMapping("/product/{id}")
    public ResponseDTO<Product> getProduct(@PathVariable("id") Long id)
    {
        return new ResponseDTO<Product>(
                200, "FOUND", productService.getProduct(id)
        );
    }

    @PutMapping("/product/{id}")
    public ResponseDTO<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Long productId)
    {
        return new ResponseDTO<Product>(
                200, "UPDATED", productService.updateProduct(product, productId)
        );
    }

    @PutMapping("/product")
    public ResponseDTO<List<Product>> updateProducts(@RequestBody List<ProductDTO> productsDTO)
    {
        return new ResponseDTO<List<Product>>(
                200, "UPDATED", productService.updateProducts(productList(productsDTO))
        );
    }

    @DeleteMapping("/product/{id}")
    public ResponseDTO<Product> deleteProductById(@PathVariable("id") Long productId)
    {
        productService.deleteProductById(productId);
        return new ResponseDTO<Product>(
                204, "DELETED", null
        );
    }
}
