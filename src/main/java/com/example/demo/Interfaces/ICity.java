package com.example.demo.Interfaces;

import com.example.demo.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICity extends JpaRepository<City, Integer> {

}
