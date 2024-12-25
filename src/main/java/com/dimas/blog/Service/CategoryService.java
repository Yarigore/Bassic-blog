package com.dimas.blog.Service;

import com.dimas.blog.Entities.Category;
import com.dimas.blog.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category saveCategory(Category category){

        return categoryRepository.save(category);
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category deleteCategory(Category category){
        categoryRepository.delete(category);
        return category;
    }

}
