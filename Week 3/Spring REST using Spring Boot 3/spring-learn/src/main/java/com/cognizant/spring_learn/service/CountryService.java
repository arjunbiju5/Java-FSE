package com.cognizant.spring_learn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;

@Service
public class CountryService {

    public Country getCountry(String code) {

        List<Country> countryList = new ArrayList<>();

        Country c1 = new Country();
        c1.setCode("IN");
        c1.setName("India");

        Country c2 = new Country();
        c2.setCode("US");
        c2.setName("United States");

        Country c3 = new Country();
        c3.setCode("DE");
        c3.setName("Germany");

        Country c4 = new Country();
        c4.setCode("JP");
        c4.setName("Japan");

        countryList.add(c1);
        countryList.add(c2);
        countryList.add(c3);
        countryList.add(c4);

        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        return null;
    }
}