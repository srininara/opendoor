package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Category;
import com.aconex.hackathon.opendoor.repository.CategoryRepository;
import com.aconex.hackathon.opendoor.representation.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.aconex.hackathon.opendoor.service.ObjectConverter.dto;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(ObjectConverter::dto)
                .collect(Collectors.toList());
    }

    public CategoryDto getCategory(int id) {
        Category category = categoryRepository.findOne(Integer.valueOf(id));
        return dto(category);
    }

}
