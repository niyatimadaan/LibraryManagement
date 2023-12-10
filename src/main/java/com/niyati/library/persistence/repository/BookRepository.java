package com.niyati.library.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.niyati.library.persistence.entity.Book;

public interface BookRepository extends MongoRepository<Book, String> {
  
}