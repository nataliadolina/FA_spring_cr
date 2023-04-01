package com.example.demo.Services;

import com.example.demo.Interfaces.ICity;
import com.example.demo.Models.City;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityService {
    @Autowired
    private ICity cityRepo;

    public List<City> getAllCities(){
        return cityRepo.findAll();
    }

    public List<City> getCityById(Integer id){
        Optional<City> city = cityRepo.findById(id);
        List<City> res = new ArrayList<>();
        city.ifPresent(res::add);
        return res;
    }

    public void saveCity(City city){
        cityRepo.save(city);
    }

    public void deleteCity(Integer id){
        cityRepo.deleteById(id);
    }
}
