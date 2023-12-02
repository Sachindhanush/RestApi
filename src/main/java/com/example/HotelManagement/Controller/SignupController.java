package com.example.HotelManagement.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelManagement.Entity.Signup;
import com.example.HotelManagement.Repository.SignupRepository;

@RestController
@CrossOrigin
@RequestMapping("/signup")
public class SignupController {
	@Autowired SignupRepository repo;
	@PostMapping("/post")
	private Signup PostUser(@RequestBody Signup s){
		return repo.save(s);
	}
}
