package com.BookManagement.BookStore.Service;

import com.BookManagement.BookStore.Entity.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {

  List<Book> getAllBooks();

  Book createBook(Book book);

  Optional<Book> getBookById(int id);

  Book updateBook(int id, Book book);

  void deleteBook(int id);
}
