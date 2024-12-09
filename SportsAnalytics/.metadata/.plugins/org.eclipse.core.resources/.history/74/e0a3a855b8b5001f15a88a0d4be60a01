package com.cps298.nba.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import com.cps298.nba.service.HomeService;

@Controller
public class MainController {
    private LocalDate now = LocalDate.now();
    private LocalDate yesterNow = now.minus(1, ChronoUnit.DAYS);
    private int year = now.getYear();
    private int month = now.getMonthValue();
    
    //Comment these in/out for presentation
    //private String today = month + "/" + now.getDayOfMonth() + "/" + year;;
    //private String yesterday = month + "/" + yesterNow.getDayOfMonth() + "/" + year;
    private String today = "11/1/2024";
    private String yesterday = "11/2/2024";
	
	@Autowired
	ApiServiceImp api;
	
	@Autowired
	DaoService imp;
	
	@Autowired
	HomeService homeServ;
	

	@RequestMapping("/")
	public String home(Model model) throws InterruptedException {	
		String yesterdaysGames = homeServ.displayYesterdaysGames();
		String todayGames = homeServ.displayTodaysGames();
		String playerStats = homeServ.displayPlayerStats();
		model.addAttribute("yesterGamesHTML",yesterdaysGames);
		model.addAttribute("todayGamesHTML", todayGames);
		model.addAttribute("todayDate",today);
		model.addAttribute("yesterDate", yesterday);
		model.addAttribute("playerStats",playerStats);
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
	
	@RequestMapping("/predictions")
	public String predictions(@RequestParam("gameId") int gameId, Model model) {
	    GamePrediction gamePrediction = imp.getPrediction(gameId);
	    model.addAttribute("gamePrediction", gamePrediction);
		return "predictions";
	}
}
