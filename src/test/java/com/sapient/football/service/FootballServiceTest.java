package com.sapient.football.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FootballServiceTest {
	
	@Autowired
	FootballService footballService;

	@Test
	public void standingOfAteamPositionTest() {
		footballService.findStandingOfATeam("England", "Premier League", "Liverpool");
		
	}

}
