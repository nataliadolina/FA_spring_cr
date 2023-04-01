package com.example.demo.Services;

import com.example.demo.Interfaces.IFlight;
import com.example.demo.Models.Flight;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FlightService {
    @Autowired
    private IFlight flightRepo;

    public List<Flight> getAllFlights(){
        return flightRepo.findAll();
    }

    public List<Flight> getFlightById(Integer id){
        Optional<Flight> f = flightRepo.findById(id);
        List<Flight> res = new ArrayList<>();
        f.ifPresent(res::add);
        return res;
    }

    public void saveFlight(Flight f){
        flightRepo.save(f);
    }

    public void deleteFlight(Integer id){
        flightRepo.deleteById(id);
    }
}
