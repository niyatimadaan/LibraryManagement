package com.niyati.library.exceptions;

public class BookAlreadyExistsException extends Exception {
  public BookAlreadyExistsException() {
    super("A book with the similar ID or name and author already exists.");
  }
}