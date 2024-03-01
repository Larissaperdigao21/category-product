package com.example.ProjectPort.service;

import com.example.ProjectPort.builder.ProductMapper;
import com.example.ProjectPort.dto.ProductDTO;
import com.example.ProjectPort.entity.Product;
import com.example.ProjectPort.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAllProducts() {
        return productMapper.toListDTO(productRepository.findAll());
    }

    public ProductDTO getProductById(Long id) {
        return productMapper.toDTO(productRepository.findById(id).orElse(null));
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        return productMapper.toDTO(productRepository.save(product));
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
