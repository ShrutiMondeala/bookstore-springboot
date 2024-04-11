package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Book;
import com.example.demo.services.BookServices;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class TestController {
    
    @Autowired
    private BookServices service ;

    //get the list of books
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBookList() {

        List<Book> list = service.getBookList();
       if(list.size() <= 0){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }

       return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookDetails(@PathVariable("id") int id) {

        Book book = service.getBook(id);
        if(book.equals(null)){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(book));
    }


    @PostMapping("/books")
    public ResponseEntity<Book> postMethodName(@RequestBody Book book) {
        //TODO: process POST request

        Book bookres = service.addBook(book);
        
        if(book == null){
                ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        
        return ResponseEntity.of(Optional.of(book));
    }
    
    
    
    @DeleteMapping("/books/{id}")
    public ResponseEntity<List<Book>> deleteMethodName(@PathVariable("id") int id) {
        //TODO: process POST request

       List<Book> list = service.deleteBook(id);

        if(list.size() <=0){
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        
        return ResponseEntity.of(Optional.of(list));
    }


    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateMethodName(@RequestBody Book book ,  @PathVariable("id") int id ) {
        //TODO: process POST request
        
        service.updateBook(id, book);


        return ResponseEntity.of(Optional.of(book));
    }


}
