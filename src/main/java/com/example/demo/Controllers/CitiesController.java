package com.example.demo.Controllers;

import com.example.demo.Models.City;
import com.example.demo.Services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private CityService cityService;

    @GetMapping("")
    public List<City> allCities(){
        return cityService.getAllCities();
    }
    @GetMapping("/{id}")
    public List<City> city(@PathVariable(value = "id") Integer id){
        return cityService.getCityById(id);
    }

    @PostMapping("")
    public void addCity(@RequestBody City city){
        cityService.saveCity(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody City city, @PathVariable Integer id){
        try{
            City baseCity = cityService.getCityById(id).get(0);
            baseCity.updateCity(city);
            cityService.saveCity(baseCity);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        cityService.deleteCity(id);
    }
}
