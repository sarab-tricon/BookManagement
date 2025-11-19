package com.BookManagement.BookStore.Service;

import com.BookManagement.BookStore.Entity.Category;
import com.BookManagement.BookStore.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepo;

  @Override
  public List<Category> getAllCategories() {
    return categoryRepo.findAll();
  }
//ResponseEntity<category>
  @Override
  public Optional<Category> getCategoryById(int id) {
    return categoryRepo.findById(id);
  }

  @Override
  public Category createCategory(Category category) {
    return categoryRepo.save(category);
  }

  @Override
  public Category updateCategory(int id, Category categoryDetails) {
    Category category = categoryRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    category.setName(categoryDetails.getName());
    return categoryRepo.save(category);
  }

  @Override
  public void deleteCategory(int id) {
    Category category = categoryRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    categoryRepo.delete(category);
  }
}
