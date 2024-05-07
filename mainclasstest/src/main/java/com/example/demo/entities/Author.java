package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book ; 
    
    public Book getBook() {
        return book;
    }

    private String name;
    private int age;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Author() {
    }
    public int getAge() {
        return age;
    }
    public String getPenName() {
        return penName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPenName(String penName) {
        this.penName = penName;
    }
    private String penName;
    public void setBook(Book book) {
        this.book = book;
    }



}
