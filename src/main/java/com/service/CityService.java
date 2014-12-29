package com.service;


import com.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Page<City> findCities(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }
}