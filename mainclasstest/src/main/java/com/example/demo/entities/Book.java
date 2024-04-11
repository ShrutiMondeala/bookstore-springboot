package com.example.demo.entities;

public class Book {

    @Override
    public String toString() {
        return "Book [id=" + id + ", bookTitle=" + bookTitle + ", bookAuther=" + bookAuther + "]";
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public void setBookAuther(String bookAuther) {
        this.bookAuther = bookAuther;
    }
    private int id;
    private String bookTitle;
    public int getId() {
        return id;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public String getBookAuther() {
        return bookAuther;
    }
    private String bookAuther;
    public Book(int id, String bookTitle, String bookAuther) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuther = bookAuther;
    }
    public Book() {
        //TODO Auto-generated constructor stub
    }
    
    
}
