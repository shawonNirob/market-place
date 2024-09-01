package com.shawon.marketplace.services;

import com.shawon.marketplace.dto.ProductDTO;
import com.shawon.marketplace.entities.Product;
import com.shawon.marketplace.entities.User;
import com.shawon.marketplace.repositories.ProductRepository;
import com.shawon.marketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Product addProduct(ProductDTO productDTO) {
        User seller = userRepository.findById(productDTO.getSellerId()).orElseThrow(() -> new RuntimeException("Seller not found"));
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setSeller(seller);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setSellerId(product.getSeller().getId());
        return dto;
    }
}