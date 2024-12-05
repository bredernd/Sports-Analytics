package com.cps298.nba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cps298.nba.main_entity.GamePrediction;
import com.cps298.nba.main_entity.GameSechedule;
import com.cps298.nba.service.ApiServiceImp;
import com.cps298.nba.service.DaoService;

@Controller
public class MainController {
	
	@Autowired
	ApiServiceImp api;
	
	@Autowired
	DaoService imp;
	

	@RequestMapping("/")
	public String home(Model model) throws InterruptedException {	
//		List<TeamRankings> response = api.fetchRanking();
//		model.addAttribute("response", response);
		return "home";
	}
	
	@RequestMapping("/calender")
	public String calender(Model model) {
		List<GameSechedule> gameSchedules = imp.getAllGameSchedule();
		model.addAttribute("gameSchedules", gameSchedules);
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
	
	@RequestMapping("/predictions") // @RequestParam("gameId") int gameId
	public String predictions(Model model) {
	    GamePrediction gamePrediction = imp.getPrediction(2477);
	    model.addAttribute("gamePrediction", gamePrediction);
		return "predictions";
	}
}
