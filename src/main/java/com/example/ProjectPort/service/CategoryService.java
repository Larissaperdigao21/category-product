package com.example.ProjectPort.service;

import com.example.ProjectPort.builder.CategoryMapper;
import com.example.ProjectPort.dto.CategoryDTO;
import com.example.ProjectPort.entity.Category;
import com.example.ProjectPort.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.toListDTO(categoryRepository.findAll());
    }

    public CategoryDTO getCategoryById(Long id) {
        return categoryMapper.toDTO(categoryRepository.findById(id).orElse(null));
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        return categoryMapper.toDTO(categoryRepository.save(category));
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
