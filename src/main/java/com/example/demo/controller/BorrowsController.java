package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.payload.BorrowsDto;
import com.example.demo.services.BorrowsService;

@Controller
@RequestMapping("/library")
public class BorrowsController {
	@Autowired
	BorrowsService borrowsService;
	
	//getting the book details which needs to be borrowed
	@PostMapping("/borrowData")
	public String borrowBookData(BorrowsDto borrowsDto,Model model)
	{
		System.out.println("data recived at backend : " + borrowsDto);
		//adding the book details to the model which is going to be borrowed
		model.addAttribute("bookData", borrowsDto);
		//directing to the borrow page
		return "borrow";	
	}
	
	//adding the book details and borrowers details into the database
	@PostMapping("/borrow")
	public String borrowBook(BorrowsDto borrowsDto)
	{
		System.out.println("data recived at backend : " + borrowsDto);
		String message = borrowsService.borrowBookDetails(borrowsDto);
		//redirecting to the borrowersList page after adding the borrowers details
		return "redirect:/library/allBorrowersList";	
	}
	
	//getting all of the borrowers list from the database
	@GetMapping("/allBorrowersList")
	public String getAllBorrowersList(Model model)
	{
		List<BorrowsDto> borrowersList = borrowsService.getAllBorrowersList();
		model.addAttribute("allBorrowers", borrowersList);
		//directing to the borrowsList page
		return "borrowsList";
	}
	
	//updating the details of the borrower when the book is returned back
	@PostMapping("/returnBook")
	public String returnBook(@RequestParam int id,Model model) {
		System.out.println("data received : " + id);
		String msg = borrowsService.returnBook(id);
		model.addAttribute("msg", msg);
		//redirecting to the borroweersList page after updating the returned book
		return "redirect:/library/allBorrowersList";
		
	}
}
