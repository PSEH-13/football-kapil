package com.sapient.football.model;

import java.util.ArrayList;
import java.util.List;

public class Countries {

	private List<Country> countries;
	
	public Countries() {
		countries = new ArrayList<>();
    }

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	
}
