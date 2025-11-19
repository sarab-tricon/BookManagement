package com.BookManagement.BookStore.Controller;

import com.BookManagement.BookStore.Entity.Book;
import com.BookManagement.BookStore.Service.BookService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;

  private static final Logger logger = LoggerFactory.getLogger(BookController.class);

  @GetMapping
  public List<Book> getAllBooks() {
    logger.info("Fetching all books");
    return bookService.getAllBooks();
  }
//ResponseEntity<Book>
  @GetMapping("/{id}")
  public Optional<Book> getBookById(@PathVariable int id) {
    logger.info("Fetching book with id: {}", id);
    return bookService.getBookById(id);
  }

  @PostMapping
  public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
    logger.info("Creating new book: {}", book.getTitle());
    Book savedBook = bookService.createBook(book);
    return ResponseEntity
        .created(URI.create("/books/" + savedBook.getId()))
        .body(savedBook);
  }

  @PutMapping("/{id}")
  public Book updateBook(@PathVariable int id, @Valid @RequestBody Book bookDetails) {
    logger.info("Updating book with id: {}", id);
    return bookService.updateBook(id, bookDetails);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable int id) {
    logger.info("Deleting book with id: {}", id);
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();
  }
}
