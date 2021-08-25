package com.lemoncode21.springbootmongodbcrud.service;

import com.lemoncode21.springbootmongodbcrud.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService{

    List<Book> retrieve();

    Optional<Book> retrieveDetail(String id);

    void  save(Book book);

    void update(Book book,String id);

    void delete(String id);
}
