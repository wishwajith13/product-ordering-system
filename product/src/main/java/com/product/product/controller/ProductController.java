package com.product.product.controller;

import com.product.product.dto.ProductDTO;
import com.product.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
//    @PreAuthorize("hasRole('client_user')")
    public List<ProductDTO> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{productId}")
    public ProductDTO getProductById(@PathVariable Integer productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{productId}")
//    @PreAuthorize("hasRole('client_admin')")
    public String deleteProduct(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }
}
