package com.niyati.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;
import com.niyati.library.persistence.repository.BookRepository;
import com.niyati.library.api.dto.*;
import com.niyati.library.persistence.entity.Book;
import com.niyati.library.exceptions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
  @Autowired
  private BookRepository bookRepository;

  @Override
  public List<BookDTO> findAllBooks() {
    List<BookDTO> response = new ArrayList<BookDTO>();

    for ( Book book: bookRepository.findAll() ) {
      response.add(
        new BookDTO(
          book.id,
          book.name,
          book.author,
          book.sales
        )
      );
    }

    return response;
  }

  @Override
  public BookDTO insertBook(CreateBookDTO bookDto) throws BookAlreadyExistsException {
    Book insertedBook;
    try {
       insertedBook = bookRepository.save(
        new Book(
          bookDto.getName(),
          bookDto.getAuthor(),
          bookDto.getSales()
        )
      );
    } catch ( DuplicateKeyException e ) {
      throw new BookAlreadyExistsException();
    }

    return new BookDTO(
      insertedBook.id,
      insertedBook.name,
      insertedBook.author,
      insertedBook.sales
    );
  }

  @Override
  public BookDTO updateBook(String id, UpdateBookDTO bookDto) throws BookDoesNotExistException {
    Optional<Book> optionalBook = bookRepository.findById(id);

    if ( optionalBook.isPresent() ) {
      Book updatedBook = optionalBook.get();
      
      if ( bookDto.getName() != null && !bookDto.getName().isEmpty() ) updatedBook.name = bookDto.getName();
      if ( bookDto.getAuthor() != null && !bookDto.getAuthor().isEmpty() ) updatedBook.author = bookDto.getAuthor();
      if ( bookDto.getSales() != null ) updatedBook.sales = bookDto.getSales();

      bookRepository.save(updatedBook);
      return new BookDTO(updatedBook.id, updatedBook.name, updatedBook.author, updatedBook.sales);
    }

    throw new BookDoesNotExistException();
  }

}