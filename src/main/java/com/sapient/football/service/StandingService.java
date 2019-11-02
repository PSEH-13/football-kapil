package com.sapient.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.football.model.Standing;
import com.sapient.football.model.TeamStanding;
import com.sapient.football.repository.StandingRepository;

@Service
public class StandingService {

	@Autowired
	StandingRepository standingRepository;

	public List<Standing> getStandingsByLeagueId(String leagueId) {
		return standingRepository.getStandingsByLeagueId(leagueId);
	}
	
	
	public TeamStanding getTeamStandingPostion(String leagueId, String teamName) {
		TeamStanding teamStandingPosition = new TeamStanding();
		List<Standing> standings = getStandingsByLeagueId(leagueId);
		
		for(Standing standing: standings) {
			if(standing.getTeam_name().equalsIgnoreCase(teamName)) {
				teamStandingPosition.setCountryName(standing.getCountry_name());
				teamStandingPosition.setTeamId(standing.getTeam_id());
				teamStandingPosition.setTeamName(standing.getTeam_name());
				teamStandingPosition.setLeagueId(standing.getLeague_id());
				teamStandingPosition.setLeagueName(standing.getLeague_name());
				teamStandingPosition.setOverallLeaguePosition(standing.getOverall_league_position());
				break;
			}
		}
		
		return teamStandingPosition;
	}
	
	
	
}

