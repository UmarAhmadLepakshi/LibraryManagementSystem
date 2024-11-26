package com.example.demo.services;

import com.example.demo.entites.Users;
import com.example.demo.payload.UsersDto;

public interface UsersService 
{
	String addUser(UsersDto userDto);

	boolean login(Users users);

}
