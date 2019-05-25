package com.elibrarysecurity.projectsecurity.service;



import com.elibrarysecurity.projectsecurity.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Category createCategory(Category category);
    void removeCategory(Category category);
    List<Category> getAllCategories();
    Optional<Category> findCategoryByNumber(int categoryNumber);



}
