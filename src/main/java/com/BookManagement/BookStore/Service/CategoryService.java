package com.BookManagement.BookStore.Service;

import com.BookManagement.BookStore.Entity.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

  List<Category> getAllCategories();

  Optional<Category> getCategoryById(int id);

  Category createCategory(Category category);

  Category updateCategory(int id, Category category);

  void deleteCategory(int id);
}
