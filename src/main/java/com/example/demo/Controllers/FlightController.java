package com.example.demo.Controllers;

import com.example.demo.Models.Flight;
import com.example.demo.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService fService;

    @GetMapping("")
    public List<Flight> allCities(){
        return fService.getAllFlights();
    }
    @GetMapping("/{id}")
    public List<Flight> flight(@PathVariable(value = "id") Integer id){
        return fService.getFlightById(id);
    }

    @PostMapping("")
    public void addFlight(@RequestBody Flight f){
        fService.saveFlight(f);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Flight f, @PathVariable Integer id){
        try{
            Flight base = fService.getFlightById(id).get(0);
            base.updateFlight(f);
            fService.saveFlight(f);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        fService.deleteFlight(id);
    }
}
