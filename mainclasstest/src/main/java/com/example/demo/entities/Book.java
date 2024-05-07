package com.example.demo.entities;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

    public Book() {
    }

    @Id
    private int id;
    public int getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Author getAuthor() {
        return author;
    }

    private String bookTitle;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;

    public void setId(int id) {
        this.id = id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthor(Author author) {
        Author auth = new Author();
       
       auth.setAge(author.getAge());
        auth.setName(author.getName());
       auth.setPenName(author.getPenName());
       auth.setId(author.getId());

       this.author= auth;
    }
   
    
    
}
