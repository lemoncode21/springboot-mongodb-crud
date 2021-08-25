package com.lemoncode21.springbootmongodbcrud.service.Implementation;

import com.lemoncode21.springbootmongodbcrud.model.Book;
import com.lemoncode21.springbootmongodbcrud.repository.BookRepository;
import com.lemoncode21.springbootmongodbcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> retrieve() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> retrieveDetail(String id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        book.setId(String.valueOf(UUID.randomUUID()));
        this.bookRepository.save(book);
    }

    @Override
    public void update(Book book,String id) {
        Optional<Book> bookData = this.bookRepository.findById(id);
        if(bookData.isEmpty()){
            System.out.print("Book id not found");
        }

        bookData.get().setPublisher(book.getPublisher());
        bookData.get().setTitle(book.getTitle());
        bookData.get().setCopies(book.getCopies());
        bookData.get().setEdition(book.getEdition());
        this.bookRepository.save(bookData.get());
    }

    @Override
    public void delete(String id) {
        this.bookRepository.deleteById(id);
    }
}
