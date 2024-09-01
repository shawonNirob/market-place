package com.shawon.marketplace.controllers;

import com.shawon.marketplace.dto.ProductDTO;
import com.shawon.marketplace.entities.Product;
import com.shawon.marketplace.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {
        Product createdProduct = productService.addProduct(productDTO);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product updatedProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}