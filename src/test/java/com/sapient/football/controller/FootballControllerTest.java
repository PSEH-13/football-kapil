package com.sapient.football.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.model.TeamStanding;
import com.sapient.football.service.FootballService;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;

@RunWith(SpringRunner.class)
@WebMvcTest(FootballController.class)
public class FootballControllerTest {

	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	FootballService footballService;
	@MockBean
    private RestTemplate restTemplate;
	
	TeamStanding teamStanding = new TeamStanding();
	@Before
	public void setup() {
		teamStanding.setCountryId("1");
		teamStanding.setCountryName("India");
		teamStanding.setLeagueId("1");
		teamStanding.setLeagueName("Championship");
		teamStanding.setOverallLeaguePosition("1");
	}
	
	
	@Test
	public void testStandings() throws Exception {
		when(footballService.findStandingOfATeam(any(String.class), any(String.class), any(String.class))).thenReturn(teamStanding);
		mockMvc.perform(get("/standings?countryName=England&leagueName=Championship&teamName=Liverpool"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.countryId", is("1")))
        .andExpect(jsonPath("$.leagueId", is("1")));
	}
	
	

}
