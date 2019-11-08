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

import com.sapient.football.model.Country;
import com.sapient.football.model.League;
import com.sapient.football.repository.CountryRepository;
import com.sapient.football.repository.LeagueRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class LeagueServiceTest {

	
	@InjectMocks
	private LeagueService leagueService;

	@Mock
	public LeagueRepository leagueRepository;

	List<League> leagues = new ArrayList<>();
	
	@Before
	public void setup() {
		
		League l1 = new League();
		l1.setCountry_id("1");
		l1.setCountry_name("India");
		l1.setLeague_id("1");
		l1.setLeague_name("Championship");
		
		leagues.add(l1);
		
	}

	@Test
	public void testLeagueByCountryId() {
		when(leagueRepository.getLeagueByCountryId(any(String.class))).thenReturn(leagues);
		List<League>  listOfLegaue = leagueService.getLeagueByCountryId("1");
		Assert.assertSame(listOfLegaue.size(), leagues.size());
	}
	
	@Test
	public void testLeagueIdByCountryIdAndLeagueName() {
		when(leagueRepository.getLeagueByCountryId(any(String.class))).thenReturn(leagues);
		String id = leagueService.getLeagueIdByCountryIdAndLeagueName("1", "Championship");
		Assert.assertSame(id, "1");
	}
	

}
