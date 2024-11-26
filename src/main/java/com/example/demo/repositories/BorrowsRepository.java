package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Borrows;

public interface BorrowsRepository extends JpaRepository<Borrows, Integer>
{
	List<Borrows> findAllByBorrowStatus(String string);

	Borrows findById(int borrowId);
}
