package com.example.HotelManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelManagement.Entity.Signup;
import com.example.HotelManagement.Service.SignUpService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	@Autowired 
	SignUpService ser;
	@GetMapping("/get")
	private Iterable<Signup> GetUsers(){
		return ser.GetAll();
	}
//	@GetMapping("/get")
//	private Iterable<SignUp> GetUsers(@PathVariable String username){
//		return ser.GetUserPassService(username);
//	}
}
