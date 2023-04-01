package com.example.demo.Interfaces;
import com.example.demo.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlight extends JpaRepository<Flight, Integer> {

}
