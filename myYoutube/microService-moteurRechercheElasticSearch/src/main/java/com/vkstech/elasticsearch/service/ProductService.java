package com.vkstech.elasticsearch.service;

import com.vkstech.elasticsearch.dto.ProductDto;
import com.vkstech.elasticsearch.entity.Product;
import com.vkstech.elasticsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(ProductDto productDto) {
        Product product = new Product(productDto.getId(), productDto.getName(), productDto.getPrice());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
