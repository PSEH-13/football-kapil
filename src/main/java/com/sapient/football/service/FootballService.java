package com.sapient.football.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.football.model.TeamStanding;

@Service
public class FootballService {

	@Autowired
	private CountryService countryService;

	@Autowired
	private StandingService standingService;

	@Autowired
	private LeagueService leagueService;

	public TeamStanding findStandingOfATeam(String countryName, String leagueName, String teamName) {

		String countryId = countryService.getCountryIdByName(countryName);
		
		String leagueId = leagueService.getLeagueIdByCountryIdAndLeagueName(countryId, leagueName);
		TeamStanding teamStandingPosition = standingService.getTeamStandingPostion(leagueId, teamName);
		
		teamStandingPosition.setCountryId(countryId);
		return teamStandingPosition;

	}

}
