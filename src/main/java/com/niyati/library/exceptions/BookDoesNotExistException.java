package com.niyati.library.exceptions;

public class BookDoesNotExistException extends Exception {
  public BookDoesNotExistException() {
    super("No book with the given ID exists.");
  }
}