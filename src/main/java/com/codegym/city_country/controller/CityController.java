package com.codegym.city_country.controller;

import com.codegym.city_country.model.City;
import com.codegym.city_country.service.city.ICityService;
import com.codegym.city_country.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
@CrossOrigin("*")
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("cityList")
    public Iterable<City> cityList(){
        return cityService.findAll();
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<City>> allCustomer(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<City> createCustomer(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id){
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> showEdit(@PathVariable Long id){
        return new ResponseEntity<>(cityService.findById(id).get(),HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<City> Edit(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
