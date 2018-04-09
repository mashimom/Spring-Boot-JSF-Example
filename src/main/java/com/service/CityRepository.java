package com.service;

import com.domain.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    List<City> findByNameContainingAndCountryContainingAllIgnoringCase(@Param("name") String name,
                                                                       @Param("country") String country);

    List<City> findByNameAndCountryAllIgnoringCase(@Param("name") String name,
                                                   @Param("country") String country);

}