package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Book;
import java.util.List;


public interface BookRepository extends CrudRepository<Book,Integer>{

    public Book findById(int id);

}
