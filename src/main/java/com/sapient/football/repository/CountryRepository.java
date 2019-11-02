package com.sapient.football.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.model.Country;

@Repository
public class CountryRepository {
	
	@Autowired
	public RestTemplate restTemplate;
	
	public List<Country> getAllCountries() {
		
		ResponseEntity<List<Country>> countryResponse =
		        restTemplate.exchange("https://apiv2.apifootball.com/?action=get_countries&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() {
		            });
		return countryResponse.getBody();
		
	}

}
