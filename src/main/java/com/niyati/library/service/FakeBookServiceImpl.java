package com.niyati.library.service;

import com.github.javafaker.Faker;
import com.github.javafaker.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niyati.library.api.dto.CreateBookDTO;
import com.niyati.library.exceptions.*;

@Service
public class FakeBookServiceImpl implements FakeBookService {
  @Autowired
  private BookServiceImpl bookService;

  @Override
  public void seedDatabase(int numBooks) {
    Faker faker = new Faker();

    for ( int i = 0; i < numBooks; i++ ) {
      Book book = faker.book();

      try {
        this.bookService.insertBook(
          new CreateBookDTO(
            book.title(),
            book.author(),
            0L
          )
        );
      } catch ( BookAlreadyExistsException e ) {
        i--;
      }
    }
  }
}