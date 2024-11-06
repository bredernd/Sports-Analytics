package com.cps298.nba.service;

import java.time.LocalDate;
import java.time.YearMonth;

import org.springframework.stereotype.Service;

@Service
public class CalendarService {

    public String generateCalendarHtml(int year, int month) {
            StringBuilder calendarHtml = new StringBuilder();
            YearMonth yearMonth = YearMonth.of(year, month);
            
            for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
                LocalDate date = LocalDate.of(year, month, day);
                String gameFactsUrl = "gameFacts?date=" + date;
                String predictionsUrl = "predictions?date=" + date;

                calendarHtml.append("<div class='day'>").append(day);
                calendarHtml.append("<button onclick=\"location.href='").append(gameFactsUrl).append("'\">Game Facts</button>");
                calendarHtml.append("<button onclick=\"location.href='").append(predictionsUrl).append("'\">Predictions</button>");
                calendarHtml.append("</div>");
            }
            
            return calendarHtml.toString();
    }
	
}
