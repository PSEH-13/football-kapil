package com.sapient.football.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.football.model.League;
import com.sapient.football.model.Team;
import com.sapient.football.repository.LeagueRepository;
import com.sapient.football.repository.TeamRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class TeamServiceTest {
	
	@InjectMocks
	private TeamService teamService;

	@Mock
	public TeamRepository teamRepository;
	
	List<Team> teams = new ArrayList<Team>();
	
	public void setup() {
		Team team = new Team();
		team.setTeam_key("1");
		team.setTeam_name("ABC");
		
		teams.add(team);
	}

	
	@Test
	public void testTeamsByLeagueId() {
		when(teamRepository.getTeamsByLeagueId(any(String.class))).thenReturn(teams);
		List<Team>  listOfTeam = teamService.getTeamsByLeagueId("1");
		Assert.assertSame(listOfTeam.size(), teams.size());
	}
}
