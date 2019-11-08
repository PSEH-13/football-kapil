package com.sapient.football.integration;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.model.TeamStanding;
import com.sapient.football.service.FootballService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FootballIntegrationTest {
	


	    @Autowired
	    private MockMvc mockMvc;
		
		@MockBean
		FootballService footballService;
		@MockBean
	    private RestTemplate restTemplate;
		
		TeamStanding teamStanding = new TeamStanding();
		@Before
		public void setup() {
			teamStanding.setCountryId("41");
		}

		
		@Test
		public void testStandings() throws Exception {
			mockMvc.perform(get("/standings?countryName=England&leagueName=Championship&teamName=Liverpool"))
	        .andDo(MockMvcResultHandlers.print())
	        .andExpect(status().isOk());
		}
}
