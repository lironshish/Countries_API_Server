package com.example.countriesAPI;


import com.example.countriesAPI.model.Country;
import com.example.countriesAPI.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/country")
public class CountryResource {
    private final CountryService countryService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }

    /*Return HTTP response and in the body there is a list of Countries */
    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> country = countryService.findAllCountries();
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    /*Return HTTP response and in the body there is a list of Countries */
    @GetMapping("/find_country/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable("id") Long id) {
        Country country = countryService.findCountryById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }


    /*Return HTTP response and in the body there is a list of Countries */
    @GetMapping("/{name}")
    public ResponseEntity<Country> getCountry(@PathVariable("name") String name) {
        Country country = countryService.findCountryByName(name);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }


    /*Return HTTP response and in the body there is a list of Countries */
    @GetMapping("/find_coin/{name}")
    public String getCoinByName(@PathVariable("name") String name) {
        Country country = countryService.findCoinByName(name);
        if (country != null) {
            return country.getCoin();
        } else {
            return "Country not found";
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country newCountry = countryService.addCountry(country);
        return new ResponseEntity<>(newCountry, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
        Country updatedCountry = countryService.updateCountry(country);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable("id") Long id) {
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

