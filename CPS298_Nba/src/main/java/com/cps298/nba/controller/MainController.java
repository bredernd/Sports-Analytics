package com.cps298.nba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cps298.nba.main_entity.GameSechedule;
import com.cps298.nba.main_entity.TeamPlayers;
import com.cps298.nba.service.ApiServiceImp;

@Controller
public class MainController {
	
	@Autowired
	ApiServiceImp api;

	@RequestMapping("/")
	public String home(Model model) throws InterruptedException {	
		List<TeamPlayers> response = api.fetchRanking();
		model.addAttribute("response", response);
		return "home";
	}
	
	@RequestMapping("/calender")
	public String calender(Model model) {
		List<GameSechedule> venue = api.gameSechdule();
		model.addAttribute("venue", venue);
		return "calender";
	}
	
	@RequestMapping("/news")
	public String news(Model model) {
		//List<PlayerStats> response= api.fetchPlayers();
	//	model.addAttribute("response", response);
		return "news";
	}
	
	@RequestMapping("/gameFacts")
	public String gameFacts(Model model) {
//		String response = api.fetchTeamStat("lol");
//		model.addAttribute("response", response);
//		System.out.println(response);
		return "gameFacts";
	}
	
	@RequestMapping("/predictions")
	public String predictions() {
		return "predictions";
	}
}
