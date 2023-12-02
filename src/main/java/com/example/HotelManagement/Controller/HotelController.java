package com.example.HotelManagement.Controller;

import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.hibernate.grammars.hql.HqlParser.SortDirectionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Repository.HotelRepository;
import com.example.HotelManagement.Service.HotelService;

@CrossOrigin("*")
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;
    @GetMapping(value="/get")
    public List<Hotel> getAllEmployees(){
        return hotelRepository.findAll();
    }
    @GetMapping(value="/{currentPage}/{itemsPerPage}/{sortBy}/{sortOrder}")
    public Page<Hotel> getData(@PathVariable(value="currentPage") int page,
                                              @PathVariable(value= "itemsPerPage") int size,
                                              @PathVariable(value= "sortBy") String field,
                                              @PathVariable(value= "sortOrder") String direction) {
    	Pageable paging;
   if(direction.equals("asc")) {
   paging=PageRequest.of(page-1, size).withSort(Sort.by(field));
   }
   else {
	   paging=PageRequest.of(page-1, size).withSort(Sort.by(field).descending());       
   }
  return  hotelRepository.findAll(paging);
    }	
    @PostMapping
    public Hotel createEmployee(@RequestBody Hotel employee) {
        return hotelRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Hotel>> getEmployeeById(@PathVariable  int id){
        Optional<Hotel> employee = hotelRepository.findById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
	public Hotel updateBookDetails(@RequestBody Hotel b)
	{
		System.out.println("Changes Made Have Been Successfully Updated");
		return hotelRepository.save(b);		
	}
    @DeleteMapping("{id}")
	public String deleteDetails(@PathVariable int id)
	{
    	hotelRepository.deleteById(id);
		return "Id : "+id+" is deleted";
	}
    @DeleteMapping
    public String deleteAllDetails()
    {
    	hotelRepository.deleteAll();
    	return "All employees deleted";
    }
}