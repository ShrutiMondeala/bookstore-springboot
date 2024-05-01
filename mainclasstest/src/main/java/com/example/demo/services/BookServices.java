package com.example.demo.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.example.demo.dao.BookRepository;
import com.example.demo.entities.*; 

@Component
public class BookServices {

     @Autowired
    public BookRepository repo;

     static List<Book> bookList = new ArrayList<>();//new ArrayList<Book>();

    // static {
    //    bookList.add(new Book(12,"Programming in Java","Ram Vilas"));
    //    bookList.add(new Book(34,"Aatma tripti","Kishor Das"));
    //    bookList.add(new Book(91,"Path to Computer Science","Durgesh tiwari"));
    //    bookList.add(new Book(20,"Programming in Pyton","Ram Vilas"));
    // }


    public List<Book> getBookList(){
        //return bookList;
        System.out.println("till here");

        System.out.println(this.repo.count());
        bookList = (List<Book>) this.repo.findAll();
        return bookList;
    }

    public Book getBook(int id){

        Book book = null;
        try{
            //book = bookList.stream().filter(x-> x.getId()==id).findFirst().get();

            book = repo.findById(id);

        }
        catch(Exception e){
            e.getStackTrace();
        }
        

        return book;
    }

    public Book addBook(Book book){

        //bookList.add(book);
        System.out.println(book);
        this.repo.save(book);
        return book;

    }
    
    public List<Book> deleteBook(int id){

        //bookList = bookList.stream().filter(x-> x.getId()!=id).collect(Collectors.toList());
        repo.deleteById(id);
        return bookList;

    }

    public void updateBook(int id , Book book){

        Book bookfind = repo.findById(id);
        bookfind.setId(id);
        bookfind.setBookTitle(book.getBookTitle());

        System.out.println(book.getAuthor());
        bookfind.setAuthor(book.getAuthor());
        
        // bookfind.setBookAuther(book.getBookAuther());
        // bookList.forEach(x->{
        // if(x.getId() == id){
        //         x.setId(id);
        //         x.setBookTitle(book.getBookTitle());
        //         x.setBookAuther(book.getBookAuther());   
                
        //     }
        // });


    }
}
