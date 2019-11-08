package com.sapient.football.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.football.model.Country;
import com.sapient.football.model.TeamStanding;
import com.sapient.football.repository.CountryRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class CountryServiceTest {


	@InjectMocks
	private CountryService countryService;

	@Mock
	public CountryRepository countryRepository;

	List<Country> countries = new ArrayList<>();
	
	@Before
	public void setup() {
		
		Country c1 = new Country();
		c1.setCountry_id("1");
		c1.setCountry_name("India");
		Country c2 = new Country();
		c2.setCountry_id("2");
		c2.setCountry_name("England");
		
		countries.add(c1);
		countries.add(c2);
		
	}

	@Test
	public void testGetAllCountries() {
		when(countryRepository.getAllCountries()).thenReturn(countries);
		List<Country> listOfCountry = countryService.getCountries();
		Assert.assertSame(listOfCountry.size(), countries.size());

	}
	
	
	@Test
	public void testCountryIdByName() {
		when(countryRepository.getAllCountries()).thenReturn(countries);
		String id = countryService.getCountryIdByName("India");
		Assert.assertSame(id, "1");
	}

}
