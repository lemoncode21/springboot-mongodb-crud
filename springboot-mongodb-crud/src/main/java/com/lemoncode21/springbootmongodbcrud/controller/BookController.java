package com.lemoncode21.springbootmongodbcrud.controller;

import com.lemoncode21.springbootmongodbcrud.model.Book;
import com.lemoncode21.springbootmongodbcrud.response.ResponseHandler;
import com.lemoncode21.springbootmongodbcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseHandler add(@RequestBody Book book){
        try {
            this.bookService.save(book);
            return new ResponseHandler(HttpStatus.OK.toString(),"Success saved data!");
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    @GetMapping
    public ResponseHandler getAll(){
        try {
            List<Book> bookList = this.bookService.retrieve();
            return new ResponseHandler(HttpStatus.OK.toString(),"Success retrieve data!",bookList);
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseHandler getDetail(@PathVariable("id")String id){
        try {
            Optional<Book> book = this.bookService.retrieveDetail(id);
            return new ResponseHandler(HttpStatus.OK.toString(),"Success retrieve detail data!",book);
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public  ResponseHandler update(@PathVariable("id")String id,@RequestBody Book book){
        try {
            this.bookService.update(book,id);
            return new ResponseHandler(HttpStatus.OK.toString(),"Success update data!");
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseHandler delete(@PathVariable("id")String id){
        try {
            this.bookService.delete(id);
            return new ResponseHandler(HttpStatus.OK.toString(),"Success delete data!");
        }catch (Exception e){
            return new ResponseHandler(HttpStatus.MULTI_STATUS.toString(),e.getMessage());
        }
    }



}
