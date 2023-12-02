package com.example.HotelManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelManagement.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Integer>{

}
