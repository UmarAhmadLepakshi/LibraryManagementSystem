package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Books;
import com.example.demo.exception.BookIdNotFoundException;
import com.example.demo.payload.BooksDto;
import com.example.demo.repositories.BooksRepository;

@Service
public class BooksServiceImplemenation implements BooksService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	BooksRepository booksRepo;

	@Override
	public void addNewBook(BooksDto bookDto) {
		Books book = modelMapper.map(bookDto, Books.class);
		booksRepo.save(book);
		
	}

	@Override
	public List<BooksDto> getAllBooks() {
		List<Books> books = booksRepo.findAll();
		List<BooksDto> booksDto = books.stream().map(
				book -> modelMapper.map(book, BooksDto.class)).collect(Collectors.toList());
		return booksDto;
	}

	@Override
	public String updateBook(BooksDto bookDto) {
		Books books = modelMapper.map(bookDto, Books.class);
		Books book = booksRepo.findById(books.getBookId()).orElseThrow(
				() -> new BookIdNotFoundException(String.format("order id %d not found", books.getBookId()))
				);
		book.setBookName(books.getBookName());
		book.setAuthor(books.getAuthor());
		book.setPublishedYear(books.getPublishedYear());;
		booksRepo.save(book);
		return "Successfullt updated the book";
	}

	@Override
	public String removeBook(int bookId) {
		Books book = booksRepo.findById(bookId).orElseThrow(
				() -> new BookIdNotFoundException(String.format("book id %d not found", bookId))
				);
		booksRepo.deleteById(book.getBookId());
		return "Successfully removed the book in the library";
	}

}
