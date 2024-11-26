package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entites.Users;
import com.example.demo.payload.UsersDto;
import com.example.demo.services.UsersService;

@Controller
@RequestMapping("/library")
public class UsersController {
	@Autowired
	UsersService usersService;
	
	//getting the user login credentials from the user
	@PostMapping("/login")
	public String login(Users users){
		System.out.println("received data = "+ users);
		//sending the details to validate the credentials 
		boolean validCredentials = usersService.login(users);
		//if the credentials are correct 
		if(validCredentials) {
			//then redirecting to the add page after successful login
			return "add";
		}
		//if not then redirecting back to login page
		return "index";
	}
	
	//getting and adding the new user details into the database
	@PostMapping("/addUser")
	public String addUser(@RequestBody UsersDto userDto) {
		System.out.println("received data : "+ userDto);
		return usersService.addUser(userDto);
	}
	
	//logging out the user
	@GetMapping("/logout")
    public String logout() {
		//directing to the login page after logout
        return "index"; 
    }
}
