package com.example.HotelManagement.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.HotelManagement.Entity.Signup;
import com.example.HotelManagement.Repository.SignupRepository;
@Service
public class SignUpService {
	@Autowired 
	SignupRepository repo;
//	public Iterable<SignUp> GetUserPassService(String username){
//		return repo.findAllUsernamePassword(username);
//	}
	public Iterable<Signup> GetAll(){
		return repo.findAll();
	}
	
}
