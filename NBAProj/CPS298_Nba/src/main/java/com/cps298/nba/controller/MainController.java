package com.cps298.nba.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cps298.nba.service.CalendarService;

@Controller
public class MainController {
	
    @Autowired
    private CalendarService calendarService;

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/calendar")
	public String calendar(Model model) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();

        // Use the service to generate the HTML
        String calendarHtml = calendarService.generateCalendarHtml(year, month);
        
        model.addAttribute("calendarHtml", calendarHtml);
        model.addAttribute("month", now.getMonth());
        model.addAttribute("year", year);
		
		return "calendar";
	}
	
	@RequestMapping("/news")
	public String news() {
		return "news";
	}
	
	@GetMapping("/gameFacts")
	public String showGameFacts(@RequestParam("date") String date, Model model) {
	    model.addAttribute("date", date);
	    return "gameFacts";
	}

	@GetMapping("/predictions")
	public String showPredictions(@RequestParam("date") String date, Model model) {
	    model.addAttribute("date", date);
	    return "predictions"; 
	}
}
