package com.codegym.city_country.controller;

import com.codegym.city_country.model.Country;
import com.codegym.city_country.service.city.ICityService;
import com.codegym.city_country.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Country>> allProvinces(){
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }


}
