package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_from_id", referencedColumnName = "id")
    private City cityFrom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_to_id", referencedColumnName = "id")
    private City cityTo;

    public void updateRoute(Route r){
        if(r.cityFrom != null){
            this.cityFrom = r.cityFrom;
        }
        if(r.cityTo != null){
            this.cityTo = r.cityTo;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }
}
