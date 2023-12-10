package com.niyati.library.service;

import com.niyati.library.api.dto.BookDTO;
import com.niyati.library.api.dto.CreateBookDTO;
import com.niyati.library.api.dto.UpdateBookDTO;
import com.niyati.library.exceptions.BookAlreadyExistsException;
import com.niyati.library.exceptions.BookDoesNotExistException;

import java.util.List;

public interface BookService {
    List<BookDTO> findAllBooks();

    BookDTO insertBook(CreateBookDTO bookDto) throws BookAlreadyExistsException;

    BookDTO updateBook(String id, UpdateBookDTO bookDto) throws BookDoesNotExistException;
}
