package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Books;

public interface BooksRepository extends JpaRepository<Books, Integer>{

}
