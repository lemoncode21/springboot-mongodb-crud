package com.lemoncode21.springbootmongodbcrud.repository;

import com.lemoncode21.springbootmongodbcrud.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {
}
