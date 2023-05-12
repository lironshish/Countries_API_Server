package com.example.countriesAPI.repo;

import com.example.countriesAPI.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CountryRepo extends JpaRepository<Country,Long> {
   /*Spring is able to understand this language and then create the query for us -> to delete an employee by ID*/

    /* Optional -> Maybe the employee doesn't exist*/

    Optional<Country> findCountryById(Long id);
    Optional<Country> findCoinByName(String name);
    Optional<Country> findCountryByName(String name);

    void deleteCountryById(Long id);
}
