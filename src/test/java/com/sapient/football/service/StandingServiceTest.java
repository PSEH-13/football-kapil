package com.sapient.football.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.football.model.League;
import com.sapient.football.model.Standing;
import com.sapient.football.model.TeamStanding;
import com.sapient.football.repository.LeagueRepository;
import com.sapient.football.repository.StandingRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class StandingServiceTest {

	
	@InjectMocks
	private StandingService standingService;

	@Mock
	public StandingRepository standingRepository;

	List<Standing> standings = new ArrayList<>();
	
	@Before
	public void setup() {
		
		Standing s1 = new Standing();
		s1.setCountry_name("India");
		s1.setLeague_id("1");
		s1.setLeague_name("Championship");
		s1.setOverall_league_position("1");
		s1.setTeam_name("Liverpool");
		
		standings.add(s1);
		
	}

	@Test
	public void testStandingsByLeagueId() {
		when(standingRepository.getStandingsByLeagueId(any(String.class))).thenReturn(standings);
		List<Standing>  listOfStanding = standingService.getStandingsByLeagueId("1");
		Assert.assertSame(listOfStanding.size(), standings.size());
	}
	
	@Test
	public void testTeamStandingPostion() {
		when(standingRepository.getStandingsByLeagueId(any(String.class))).thenReturn(standings);
		TeamStanding standing = new TeamStanding();
		standing = standingService.getTeamStandingPostion("1", "Liverpool");
		Assert.assertSame(standing.getOverallLeaguePosition(), "1");
	}
}
