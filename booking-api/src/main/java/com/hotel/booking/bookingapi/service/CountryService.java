package com.hotel.booking.bookingapi.service;

import com.hotel.booking.bookingapi.entity.Country;
import com.hotel.booking.bookingapi.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CountryService {


    public final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    public List<Country> getCountries() {
        return (List<Country>) countryRepository.findAll();
    }
}
