package com.dimas.blog.Controllers;

import com.dimas.blog.Entities.Category;
import com.dimas.blog.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategory() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @DeleteMapping
    public ResponseEntity<Category> deleteCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.deleteCategory(category));
    }

}
