package com.example.countriesAPI.service;

import com.example.countriesAPI.exception.CoinNotFoundException;
import com.example.countriesAPI.exception.CountryNotFoundException;
import com.example.countriesAPI.model.Country;
import com.example.countriesAPI.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryService {
    private final CountryRepo countryRepo;

    @Autowired
    public CountryService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public Country addCountry(Country country) {
        return countryRepo.save(country);
    }

    public List<Country> findAllCountries() {
        return countryRepo.findAll();
    }

    public Country updateCountry(Country country) {
        return countryRepo.save(country);
    }

    public Country findCountryById(Long id) {
        return countryRepo.findCountryById(id)
                .orElseThrow(() -> new CountryNotFoundException("Country by id " + id + " was not found"));
    }

    public Country findCountryByName(String name) {
        return countryRepo.findCountryByName(name)
                .orElseThrow(() -> new CountryNotFoundException("Country " + name + " was not found"));
    }

    public Country findCoinByName(String name) {
        return countryRepo.findCoinByName(name)
                .orElseThrow(() -> new CoinNotFoundException("Coin by Country " + name + " was not found"));
    }

    public void deleteCountry(Long id) {
        countryRepo.deleteCountryById(id);
    }

    public List<Country> listAll() {
        return countryRepo.findAll(Sort.by("id").ascending());
    }

}