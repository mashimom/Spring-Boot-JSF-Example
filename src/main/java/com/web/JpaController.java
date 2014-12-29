package com.web;

import com.domain.City;
import com.service.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Component
@Scope("view")
public class JpaController implements Serializable {
    @Autowired
    private CityRepository cityRepository;
    private Page<City> cities;

    @PostConstruct
    public void init(){
        cityRepository.save(new City("Göteborg", "", "Sweden", ""));
        cities = cityRepository.findAll(new PageRequest(0, 100));
        System.out.println("cities.getTotalElements() = " + cities.getTotalElements());
    }

    public Page<City> getCities() {
        System.out.println("cities.getTotalElements() = " + cities.getTotalElements());
        return cities;

    }

    public void setCities(Page<City> cities) {
        this.cities = cities;
    }
}
