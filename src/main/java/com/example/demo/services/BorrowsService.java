package com.example.demo.services;

import java.util.List;

import com.example.demo.payload.BorrowsDto;

public interface BorrowsService {
	
	String borrowBookDetails(BorrowsDto borrowsDto);

	List<BorrowsDto> getAllBorrowersList();

	String returnBook(int borrowId);

}
