package com.example.demo.services;

import java.util.List;

import com.example.demo.payload.BooksDto;

public interface BooksService {
	
	void addNewBook(BooksDto bookDto);

	List<BooksDto> getAllBooks();

	String updateBook(BooksDto bookDto);

	String removeBook(int bookId);

}
