package com.example.drools.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.drools.model.FootballClubRequest;

@RestController
public class CountryLeagueController {

	@Autowired
	private KieContainer kieContainer;

	@RequestMapping(value = "/getLeagueWinner", method = RequestMethod.GET, produces = "application/json")
	public String getLeagueWinner(@RequestParam(required = true) String country, @RequestParam(required = true) String year) {
		KieSession kieSession = kieContainer.newKieSession();
		FootballClubRequest footballRequest = new FootballClubRequest(country , year);
		kieSession.insert(footballRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		return "The champions are " + footballRequest.getWinner();
	}
}