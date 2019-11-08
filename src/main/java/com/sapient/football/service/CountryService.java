package com.sapient.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.football.model.Country;
import com.sapient.football.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	public CountryRepository countryRepository;
	
	public List<Country> getCountries() {
		return countryRepository.getAllCountries();
	}
	
	
	public String getCountryIdByName(String countryName) {
		
		List<Country> countries = getCountries();
		
		for(Country country : countries) {
			if(country.getCountry_name().equalsIgnoreCase(countryName)) {
				return country.getCountry_id();
			}
		}
		return "";
	}
	
}
	
