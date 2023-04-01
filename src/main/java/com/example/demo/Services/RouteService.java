package com.example.demo.Services;

import com.example.demo.Interfaces.IRoute;
import com.example.demo.Models.Route;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RouteService {
    @Autowired
    private IRoute routeRepo;

    public List<Route> getAllRoutes(){
        return routeRepo.findAll();
    }

    public List<Route> getRouteById(Integer id){
        Optional<Route> city = routeRepo.findById(id);
        List<Route> res = new ArrayList<>();
        city.ifPresent(res::add);
        return res;
    }

    public void saveRoute(Route route){
        routeRepo.save(route);
    }

    public void deleteRoute(Integer id){
        routeRepo.deleteById(id);
    }
}
