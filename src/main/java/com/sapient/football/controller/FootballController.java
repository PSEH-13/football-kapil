package com.sapient.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.football.model.TeamStanding;
import com.sapient.football.service.FootballService;

@RestController
public class FootballController {
	
	@Autowired
	FootballService footballService;
	
	@RequestMapping("/standings")
	public TeamStanding getStandings(@RequestParam("countryName") String countryName, @RequestParam("leagueName") String leagueName,
			@RequestParam("teamName") String teamName) {
		return footballService.findStandingOfATeam(countryName, leagueName, teamName);
	}

}
