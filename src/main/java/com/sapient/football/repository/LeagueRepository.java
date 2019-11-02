package com.sapient.football.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.model.League;

@Repository
public class LeagueRepository {

	@Autowired
	public RestTemplate restTemplate;
	
	public List<League> getLeagueByCountryId(String countryId) {
		StringBuilder url = new StringBuilder();
		url.append("https://apiv2.apifootball.com/?action=get_leagues&country_id=").append(countryId)
			.append("&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
		
		ResponseEntity<List<League>> leagueResponse =
		        restTemplate.exchange(url.toString(),
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<League>>() {
		            });
		return leagueResponse.getBody();
		
	}

	
}
