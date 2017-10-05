package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Category;
import com.aconex.hackathon.opendoor.repository.CategoryRepository;
import com.aconex.hackathon.opendoor.representation.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category ->
                new CategoryDto(category.getId(), category.getName(), category.getShortDescription(), category.getFullDescription()))
                .collect(Collectors.toList());
    }

    public Category getCategory(int id) {
        return categoryRepository.findOne(Integer.valueOf(id));
    }

}
