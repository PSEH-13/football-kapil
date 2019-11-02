package com.sapient.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.football.model.Team;
import com.sapient.football.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	TeamRepository teamRepository;

	public List<Team> getTeamsByLeagueId(String leagueId) {
		return teamRepository.getTeamsByLeagueId(leagueId);
	}

}
