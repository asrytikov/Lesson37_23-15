package com.example.lesson37;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/ciao")
    public String ciao(){
        return "Ciao!";
    }

    @GetMapping("/france")
    public Country france(){
        Country country = Country.of("France", 67);
        return country;
    }

    @GetMapping("/all")
    public List<Country> countryList(){
        Country country1 = Country.of("France", 67);
        Country country2 = Country.of("Spain", 47);
        return List.of(country1, country2);
    }

    @GetMapping("/sweden")
    public ResponseEntity<Country> sweden(){
        Country country = Country.of("Sweden", 98);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Stokgolm")
                .header("favorite_food", "fish")
                .body(country);
    }

}
