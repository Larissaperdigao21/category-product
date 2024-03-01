package com.example.ProjectPort.builder;

import com.example.ProjectPort.dto.ProductDTO;
import com.example.ProjectPort.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO toDTO(Product model) {
        return modelMapper.map(model, ProductDTO.class);
    }

    public Product toEntity(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

    public List<ProductDTO> toListDTO(List<Product> modelList) {
        return modelList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<Product> toList(List<ProductDTO> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}