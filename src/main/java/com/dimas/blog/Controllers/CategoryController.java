package com.dimas.blog.Controllers;

import com.dimas.blog.Entities.Category;
import com.dimas.blog.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategory() {
        return categoryService.getCategories()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PatchMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {

        Optional<Category> categoryToChange = categoryService.getCategoryById(id);

        if (categoryToChange.isPresent()){

            Category existingCategory = categoryToChange.get();

            if (category.getName() != null){
                existingCategory.setName(category.getName());
            }

            Optional<Category> updateCategory = categoryService.saveCategory(existingCategory);

            return updateCategory
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Category> deleteCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.deleteCategory(category));
    }

}
