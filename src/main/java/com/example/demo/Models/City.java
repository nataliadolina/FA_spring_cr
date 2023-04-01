package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "cityFrom", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Route> routesFrom;

    @JsonIgnore
    @OneToMany(mappedBy = "cityTo", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Route> routesTo;

    public void updateCity(City city){
        if(city.name != null){
            this.name = city.name;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
