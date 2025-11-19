package com.BookManagement.BookStore.Controller;

import com.BookManagement.BookStore.Entity.Category;
import com.BookManagement.BookStore.Service.CategoryService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

  @GetMapping
  public  ResponseEntity<List<Category>>getAllCategories() {
    logger.info("Fetching all categories");
    List<Category> categories = categoryService.getAllCategories();
    return ResponseEntity.ok(categories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
    return categoryService.getCategoryById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
    logger.info("Creating new category: {}", category.getName());
    Category savedCategory = categoryService.createCategory(category);
    logger.info("Category created with ID: {}", savedCategory.getId());
    return ResponseEntity.ok(savedCategory);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Category> updateCategory(@PathVariable int id, @Valid @RequestBody Category categoryDetails) {
    try {
      Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
      return ResponseEntity.ok(updatedCategory);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteCategory(@PathVariable int id) {
    try {
      categoryService.deleteCategory(id);
      return ResponseEntity.noContent().build();
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }
}
