package com.niyati.library.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@CompoundIndex(def = "{'name': 1, 'author': 1}", unique = true)
public class Book {

  @Id
  public String id;

  public String name;
  public String author;
  public Long sales;

  public Book() {}

  public Book(
    String name,
    String author,
    Long sales
  ) {
    this.name = name;
    this.author = author;
    this.sales = sales;
  }
}