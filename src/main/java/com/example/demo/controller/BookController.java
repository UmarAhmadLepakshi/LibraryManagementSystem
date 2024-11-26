package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.payload.BooksDto;
import com.example.demo.services.BooksService;

@Controller
@RequestMapping("/library")
public class BookController {
	@Autowired
	BooksService booksService;
	
	@GetMapping("/addBook")
	public String getAddBookPage() {
		//directing to add page
		return "add";
	}
	
	//getting all of the books from the database
	@GetMapping("/allBooksList")
	public String getAllBooks(Model model) {
		List<BooksDto> allBooks = booksService.getAllBooks();
		model.addAttribute("allBooks", allBooks);
		//directing to the library page
		return "library";
	}
	
	//adding new book into the database
	@PostMapping("/addNewBook")
	public String addNewBook(BooksDto bookDto) {
		System.out.println("data received : " + bookDto);
		booksService.addNewBook(bookDto);
		//redirecting to the booksList page after add new book
		return "redirect:/library/allBooksList";
		
	}
	
	//getting the book details which needs to be updated
	@PostMapping("/updateBookDetails")
	public String updateBookDetails(BooksDto bookDto ,Model model) {
		System.out.println("details recevied at backend: "+ bookDto);
		//adding the book details to the model to update it's details
		model.addAttribute("updateBookDetails", bookDto);
		//directing to the update page
		return "update";
		
	}
	
	//updating the book details
	@PostMapping("/updateBook")
	public String updateBook(BooksDto bookDto) {
		System.out.println("details recevied at backend: "+ bookDto);
		booksService.updateBook(bookDto);
		//redirecting to the booksList page after updating book details
		return "redirect:/library/allBooksList";
		
	}
	
	//removing the book from the database with bookId
	@PostMapping("/removeBook")
	public String removeBook(@RequestParam int bookId) {
		String message = booksService.removeBook(bookId);
		//redirecting to the booksList page after removing the book
		return "redirect:/library/allBooksList";
	}
}
