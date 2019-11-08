package com.sapient.football.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.football.model.TeamStanding;

import junit.framework.Assert;


@RunWith(SpringRunner.class)
public class FootballServiceTest {
	
	
	@InjectMocks
    private FootballService footballService;
	

    @Mock
    private CountryService countryService;
    
    @Mock
    private StandingService standingService;
    
    @Mock
    private LeagueService leagueService;
	

    @Test
    public void testOverallPosition() {
    	TeamStanding teamStandingPosition = new TeamStanding();
    	teamStandingPosition.setOverallLeaguePosition("1");
    	when(countryService.getCountryIdByName(any(String.class))).thenReturn("41");
    	when(leagueService.getLeagueIdByCountryIdAndLeagueName(any(String.class), any(String.class))).thenReturn("148");
    	when(standingService.getTeamStandingPostion(any(String.class), any(String.class))).thenReturn(teamStandingPosition);
    	
    	TeamStanding teamStanding =  footballService.findStandingOfATeam("England", "Premier League", "Liverpool");
    	
    	Assert.assertSame(teamStandingPosition.getOverallLeaguePosition(), teamStanding.getOverallLeaguePosition());
    	
    	
    }
}
