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
@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseDTO<ProductDTO> saveProduct(@Validated @RequestBody ProductDTO productDTO)
    {
        return new ResponseDTO<ProductDTO>(
                201,
                "CREATED",
                ProductMapper.mapToDTO(productService.saveProduct(
                            ProductMapper.mapToProduct(productDTO)
                    ))
        );
    }

    @PostMapping("/products")
    public ResponseDTO<List<ProductDTO>> saveProducts(@Validated @RequestBody List<ProductDTO> productsDTO)
    {
        return new ResponseDTO<List<ProductDTO>>(
                201,
                "CREATED",
                ProductMapper.dtoList(
                        productService.saveProducts(
                                ProductMapper.productList(productsDTO)
                        )
                )
        );
    }

    @GetMapping("/product")
    public ResponseDTO<List<ProductDTO>> fetchProductList()
    {
        return new ResponseDTO<List<ProductDTO>>(
                200,
                "FOUND",
                ProductMapper.dtoList(
                        productService.fetchProductList()
                )
        );
    }

    @GetMapping("/product/{id}")
    public ResponseDTO<ProductDTO> getProduct(@PathVariable("id") Long id)
    {
        return new ResponseDTO<ProductDTO>(
                200,
                "FOUND",
                ProductMapper.mapToDTO(
                        productService.getProduct(id)
                )
        );
    }

    @PutMapping("/product/{id}")
    public ResponseDTO<ProductDTO> updateProduct(@RequestBody Product product, @PathVariable("id") Long productId)
    {
        return new ResponseDTO<ProductDTO>(
                200,
                "UPDATED",
                ProductMapper.mapToDTO(
                        productService.updateProduct(product, productId)
                )
        );
    }

    @PutMapping("/product")
    public ResponseDTO<List<ProductDTO>> updateProducts(@RequestBody List<ProductDTO> productsDTO)
    {
        return new ResponseDTO<List<ProductDTO>>(
                200,
                "UPDATED",
                ProductMapper.dtoList(
                        productService.updateProducts(ProductMapper.productList(productsDTO))
                )
        );
    }

    @DeleteMapping("/product/{id}")
    public ResponseDTO<ProductDTO> deleteProductById(@PathVariable("id") Long productId)
    {
        productService.deleteProductById(productId);
        return new ResponseDTO<ProductDTO>(
                204,
                "DELETED",
                null
        );
    }
}
