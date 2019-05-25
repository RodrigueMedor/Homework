package com.elibrarysecurity.projectsecurity.service.impl;


import com.elibrarysecurity.projectsecurity.model.Category;
import com.elibrarysecurity.projectsecurity.repository.ICategoryRepository;
import com.elibrarysecurity.projectsecurity.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    public ICategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Category category) {
       categoryRepository.delete(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll(Sort.by("categoryName"));
    }

    @Override
    public Optional<Category> findCategoryByNumber(int categoryNumber) {
        return categoryRepository.findById(categoryNumber);
    }
}
