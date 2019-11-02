package com.sapient.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.football.model.League;
import com.sapient.football.repository.LeagueRepository;

@Service
public class LeagueService {

	@Autowired
	public LeagueRepository leagueRepository;
	
	public List<League> getLeagueByCountryId(String countryId) {
		return leagueRepository.getLeagueByCountryId(countryId);
		
	}
	
	public String getLeagueIdByCountryIdAndLeagueName(String countryId, String leagueName) {
		List<League> leagues = getLeagueByCountryId(countryId);
		for (League league : leagues) {
			if (league.getLeague_name().equalsIgnoreCase(leagueName)) {
				return league.getLeague_id();
			}
		}
		return "";
	}
	

	
}
