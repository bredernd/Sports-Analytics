package com.cps298.nba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/calender")
	public String calender() {
		return "calender";
	}
	
	@RequestMapping("/news")
	public String news() {
		return "news";
	}
	
	@RequestMapping("/gameFacts")
	public String gameFacts() {
		return "gameFacts";
	}
	
	@RequestMapping("/predictions")
	public String predictions() {
		return "predictions";
	}
}
