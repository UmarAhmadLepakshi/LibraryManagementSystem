package com.example.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Users;
import com.example.demo.payload.UsersDto;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersServiceImplementation  implements UsersService
{
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UsersRepository usersRepo;

	@Override
	public String addUser(UsersDto userDto) {
		Users user = modelMapper.map(userDto, Users.class);
		usersRepo.save(user);
		return "user data is saved";
	}

	@Override
	public boolean login(Users users) {
		Users user = usersRepo.findByUserEmail(users.getUserEmail());
		if(user != null && user.getUserPasswd().equals(users.getUserPasswd())) {
			return true;
		}
		return false;
	}

}
