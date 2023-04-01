package com.example.demo.Controllers;

import com.example.demo.Models.Route;
import com.example.demo.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/routes")
public class RoutesConstroller {
    @Autowired
    private RouteService routeService;

    @GetMapping("")
    public List<Route> allCities(){
        return routeService.getAllRoutes();
    }
    @GetMapping("/{id}")
    public List<Route> city(@PathVariable(value = "id") Integer id){
        return routeService.getRouteById(id);
    }

    @PostMapping("")
    public void addCity(@RequestBody Route route){
        routeService.saveRoute(route);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Route route, @PathVariable Integer id){
        try{
            Route base = routeService.getRouteById(id).get(0);
            base.updateRoute(route);
            routeService.saveRoute(base);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        routeService.deleteRoute(id);
    }
}
