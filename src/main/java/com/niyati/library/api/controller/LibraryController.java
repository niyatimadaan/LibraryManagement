package com.niyati.library.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import com.niyati.library.api.dto.*;
import com.niyati.library.exceptions.*;
import com.niyati.library.service.BookServiceImpl;
import java.util.List;


@RestController
@RequestMapping("/api")
@Validated
public class LibraryController {
  @Autowired
  private BookServiceImpl bookService;

  @GetMapping("/books")
  public List<BookDTO> findAllBooks() {
    return this.bookService.findAllBooks();
  }

  @PostMapping("/books")
  public BookDTO insertBook(@Valid @RequestBody CreateBookDTO bookDto) throws BookAlreadyExistsException {
    return this.bookService.insertBook(bookDto);
  }

  @PutMapping("/books/{id}")
  public BookDTO updateBook(
    @PathVariable String id,
    @Valid @RequestBody UpdateBookDTO bookDto
  ) throws BookDoesNotExistException {
    return this.bookService.updateBook(id, bookDto);
  }
}