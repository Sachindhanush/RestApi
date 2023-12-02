package com.example.HotelManagement.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.HotelManagement.Entity.Signup;
@Repository
public interface SignupRepository extends CrudRepository<Signup,Integer>{

}
