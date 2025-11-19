package com.BookManagement.BookStore.Service;

import com.BookManagement.BookStore.Entity.Book;
import com.BookManagement.BookStore.Repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepo;

  @Override
  public List<Book> getAllBooks() {
    return bookRepo.findAll();
  }

  @Override
  public Book createBook(Book book) {
    return bookRepo.save(book);
  }

  @Override
  public Optional<Book> getBookById(int id) {
    return bookRepo.findById(id);
  }

  @Override
  public Book updateBook(int id, Book bookDetails) {
    Book book = bookRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

    book.setTitle(bookDetails.getTitle());
    book.setPrice(bookDetails.getPrice());
    book.setCategory(bookDetails.getCategory());

    return bookRepo.save(book);
  }

  @Override
  public void deleteBook(int id) {
    Book book = bookRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    bookRepo.delete(book);
  }
}
