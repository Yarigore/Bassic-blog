package com.dimas.blog.Service;

import com.dimas.blog.Entities.Category;
import com.dimas.blog.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Optional<Category> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public Optional<List<Category>> getCategories() {
        return Optional.of(categoryRepository.findAll());
    }

    public Optional<Category> saveCategory(Category category) {
        return Optional.of(categoryRepository.save(category));
    }

    public Category deleteCategory(Category category) {
        categoryRepository.delete(category);
        return category;
    }

}
