package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Borrows;
import com.example.demo.payload.BorrowsDto;
import com.example.demo.repositories.BorrowsRepository;

@Service
public class BorrowsServiceImplementation implements BorrowsService{
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	BorrowsRepository borrowsRepo;

	@Override
	public String borrowBookDetails(BorrowsDto borrowsDto) {
		Borrows borrower = modelMapper.map(borrowsDto, Borrows.class);
		borrowsRepo.save(borrower);
		return "borrower details are added successfully";
	}

	@Override
	public List<BorrowsDto> getAllBorrowersList() {
		List<Borrows> borrowers = borrowsRepo.findAllByBorrowStatus("NOT-RETURNED");
		List<BorrowsDto> borrowersList = borrowers.stream().map(
				borrower -> modelMapper.map(borrower, BorrowsDto.class)
				).collect(Collectors.toList());
		return borrowersList;
	}

	@Override
	public String returnBook(int borrowId) {
		Borrows borrow = borrowsRepo.findById(borrowId);
		borrow.setBorrowStatus("returned");
		borrowsRepo.save(borrow);
		return "Successfully returned by the borrower";
	}
}
