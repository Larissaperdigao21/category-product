package com.example.ProjectPort.builder;

import com.example.ProjectPort.dto.CategoryDTO;
import com.example.ProjectPort.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    private final ModelMapper modelMapper;

    public CategoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoryDTO toDTO(Category model) {
        return modelMapper.map(model, CategoryDTO.class);
    }

    public Category toEntity(CategoryDTO dto) {
        return modelMapper.map(dto, Category.class);
    }

    public List<CategoryDTO> toListDTO(List<Category> modelList) {
        return modelList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<Category> toList(List<CategoryDTO> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}