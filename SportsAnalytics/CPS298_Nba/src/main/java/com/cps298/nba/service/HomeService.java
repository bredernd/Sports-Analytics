package com.cps298.nba.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cps298.nba.main_entity.GameSechedule;
import com.cps298.nba.main_entity.PlayerStats;
import com.cps298.nba.main_entity.TeamPlayers;
import com.cps298.nba.main_entity.TeamStats;
import com.cps298.nba.main_entity.Teams;

@Service
public class HomeService {
    private LocalDate now = LocalDate.now();
    
    //comment these values in/out for presentation
    //private String today = now.toString();
    //private String yesterday = now.minus(1, ChronoUnit.DAYS).toString();
  private String today = "2024-11-01";
  private String yesterday = "2024-11-02";
	
	@Autowired
	DaoService imp;
	
	
	public String displayYesterdaysGames() {
		StringBuilder gameStats = new StringBuilder();
		//List<GameSechedule> gameSched = imp.getAllGameSchedule();
		List<GameSechedule> gameSched = imp.getGamesByDate(yesterday);
		
		//Looping through the DB to get info for each game today, and then plugging that data into HTML code to be returned and used in controller.
		for(GameSechedule each : gameSched) {
			
			//yeah idk, doesn't feel like finding games by date loads it any faster than looping through the whole DB, just gonna leave it commented out.
			//if(each.getScheduled().equals(yesterday)) {
				
				//Getting all the data we need for comparison to highlight when displaying
				Teams home = each.getHome_team();
				Teams away = each.getAway_team();
				String homeId = home.getTeamId();
				String awayId = away.getTeamId();
				TeamStats homeStats = imp.getTeamStats(homeId);
				TeamStats awayStats = imp.getTeamStats(awayId);
				int homePoints = 0;
				int awayPoints = 0;
				String homeResult ="";
				String awayResult ="";
				String homeName = checkName(home.getName());
				String awayName = checkName(away.getName());
				
				
				if(each.getHome_points() != null && each.getAway_points() != null) {
					homePoints = each.getHome_points();
					awayPoints = each.getAway_points();
					if(homePoints > awayPoints) {
						homeResult = "win";
						awayResult = "lose";
					}
					else {
						homeResult = "lose";
						awayResult = "win";
					}
				}

				

				// appending the final return result with each games stats when it gets looped.
				gameStats.append(
						"		<div class=\"matchCont\">\r\n"
						+ "			<div class=\"homeCont\">\r\n"
						+ "				<div class=\"" + "logo " + homeName + "\"></div>\r\n"
						+ "				<div class=\"infoCont\">\r\n"
						+ "					<div class=\"homeTeamName\">" + home.getName().toUpperCase() + "</div>\r\n"
						+ "					<div class=\"statsCont\">\r\n"
						+ "						<div class=\"standingsCont\">\r\n"
						+ "							<div class=\"standingsTopCont\">\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">Off-Rat</div>\r\n"
						+ "									<div class=\"standingsStat\">" + homeStats.getOffensive_rating() + "</div>\r\n"
						+ "								</div>\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">Deff-Rat</div>\r\n"
						+ "									<div class=\"standingsStat\">" + homeStats.getDefensive_rating() + "</div>\r\n"
						+ "								</div>\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">Net-Rat</div>\r\n"
						+ "									<div class=\"standingsStat\">" + homeStats.getNet_rating() + "</div>\r\n"
						+ "								</div>\r\n"
						+ "							</div>\r\n"
						+ "							<div class=\"standingsBotCont\">\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">3Pnt-Avg</div>\r\n"
						+ "									<div class=\"standingsStat\">" + calcThreeAverage(homeStats) + "</div>\r\n"
						+ "								</div>\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">2Pnt-Avg</div>\r\n"
						+ "									<div class=\"standingsStat\">" + calcTwoAverage(homeStats) + "</div>\r\n"
						+ "								</div>\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">FT-Avg</div>\r\n"
						+ "									<div class=\"standingsStat\">" + calcFreeThrowAverage(homeStats) + "</div>\r\n"
						+ "								</div>\r\n"
						+ "							</div>\r\n"
						+ "						</div>\r\n"
						+ "						<div class=\"scoreCont\">\r\n"
						+ "							<div class=\"scoreTitle\">Score</div>\r\n"
						+ "							<div class=\"score " + homeResult + " \">" + homePoints + "</div>\r\n"
						+ "						</div>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n"
						+ "			</div>\r\n"
						+ "			<div class=\"vsLogo\"></div>\r\n"
						+ "			<div class=\"awayCont\">\r\n"
						+ "				<div class=\"infoCont\">\r\n"
						+ "					<div class=\"awayTeamName\">" + away.getName().toUpperCase() + "</div>\r\n"
						+ "					<div class=\"statsCont\">\r\n"
						+ "						<div class=\"scoreCont\">\r\n"
						+ "							<div class=\"scoreTitle\">Score</div>\r\n"
						+ "							<div class=\"score " + awayResult + "\">" + awayPoints + "</div>\r\n"
						+ "						</div>\r\n"
						+ "						<div class=\"standingsCont\">\r\n"
						+ "							<div class=\"standingsTopCont\">\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">Off-Rat</div>\r\n"
						+ "									<div class=\"standingsStat\">" + awayStats.getOffensive_rating() + "</div>\r\n"
						+ "								</div>\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">Deff-Rat</div>\r\n"
						+ "									<div class=\"standingsStat\">" + awayStats.getDefensive_rating() + "</div>\r\n"
						+ "								</div>\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">Net-Rat</div>\r\n"
						+ "									<div class=\"standingsStat\">" + awayStats.getNet_rating() + "</div>\r\n"
						+ "								</div>\r\n"
						+ "							</div>\r\n"
						+ "							<div class=\"standingsBotCont\">\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">3Pnt-Avg</div>\r\n"
						+ "									<div class=\"standingsStat\">" + calcThreeAverage(awayStats) + "</div>\r\n"
						+ "								</div>\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">2Pnt-Avg</div>\r\n"
						+ "									<div class=\"standingsStat\">" + calcTwoAverage(awayStats) + "</div>\r\n"
						+ "								</div>\r\n"
						+ "								<div class=\"standingsBox\">\r\n"
						+ "									<div class=\"standingsTitle\">FT-Avg</div>\r\n"
						+ "									<div class=\"standingsStat\">" + calcFreeThrowAverage(awayStats) + "</div>\r\n"
						+ "								</div>\r\n"
						+ "							</div>\r\n"
						+ "						</div>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n"
						+ "				<div class=\"logo " + awayName + "\"></div>\r\n"
						+ "			</div>\r\n"
						+ "			\r\n"
						+ "		</div>");
			//}
		}
		
		return gameStats.toString();
	}
	
	public String displayTodaysGames() {
		StringBuilder gameStats = new StringBuilder();
		//List<GameSechedule> gameSched = imp.getAllGameSchedule();
		List<GameSechedule> gameSched = imp.getGamesByDate(today);

		
		//Looping through the DB to get info for each game today, and then plugging that data into HTML code to be returned and used in controller.
		for(GameSechedule each : gameSched) {

			//if(each.getScheduled().equals(today)) {
				Teams home = each.getHome_team();
				Teams away = each.getAway_team();
				String homeId = home.getTeamId();
				String awayId = away.getTeamId();
				TeamStats homeStats = imp.getTeamStats(homeId);
				TeamStats awayStats = imp.getTeamStats(awayId);
				String homeName = checkName(home.getName());
				String awayName = checkName(away.getName());
				gameStats.append("<div class=\"game\" style=\"display: block;\">\r\n"
						+ "    			<div class=\"todayStats\">\r\n"
						+ "    				<div class=\"logo " + homeName + "\"></div>\r\n"
						+ "    				<div class=\"ratingCont\">\r\n"
						+ "    					<div class=\"netRatTitle\">Net Rating</div>\r\n"
						+ "    					<div class=\"netRatStat\">" + homeStats.getNet_rating() + "</div>\r\n"
						+ "    				</div>\r\n"
						+ "    			</div>\r\n"
						+ "    			<div class=\"vsLogo\" style=\"margin-left:225px;\"></div>\r\n"
						+ "    			<div class=\"todayStats\">\r\n"
						+ "    				<div class=\"logo " + awayName + "\"></div>\r\n"
						+ "    				<div class=\"ratingCont\">\r\n"
						+ "    					<div class=\"netRatTitle\">Net Rating</div>\r\n"
						+ "    					<div class=\"netRatStat\">" + awayStats.getNet_rating() + "</div>\r\n"
						+ "    				</div>\r\n"
						+ "    			</div>\r\n"
						+ "    		</div>"
						
						);
			//}
			
		}
			
		return gameStats.toString();
	}
	
	public String displayPlayerStats() {
		StringBuilder playerDisplay = new StringBuilder();
		
		playerDisplay.append(getBestThreeDisplay());
		playerDisplay.append(getBestBlocksDisplay());
		playerDisplay.append(getBestAssistsDisplay());
		playerDisplay.append(getBestTwoDisplay());
		playerDisplay.append(getBestStealsDisplay());
		playerDisplay.append(getBestEffDisplay());
		
		return playerDisplay.toString();
	}
	
	public Double calcFreeThrowAverage(TeamStats team) {
		Double average = (team.getFree_throws_made() / team.getFree_throws_att()) * 100.00;
		average = round(average, 2);
		return average;
	}
	
	public Double calcThreeAverage(TeamStats team) {
		Double average = (team.getThree_points_made() / team.getThree_points_att()) * 100.00;
		average = round(average, 2);
		return average;
	}
	
	public Double calcTwoAverage(TeamStats team) {
		Double average = (team.getTwo_points_made() / team.getTwo_points_att()) * 100.00;
		average = round(average, 2);
		return average;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public String checkName(String name) {
		String finalName = name.toLowerCase();
		switch(finalName){
		case "76ers":
			finalName = "sevensix";
			break;
		case "trail blazers":
			finalName = "trail";
			break;
		default:
			break;
		}
		
		return finalName;
	}
	
	
	public String getBestThreeDisplay() {
		StringBuilder threesDisplay = new StringBuilder();
		
		PlayerStats threes = imp.getBestThreePntEff();
		
		threesDisplay.append("			<div class=\"player\" style=\"display: flex;\">\r\n"
				+ "				<div class=\"playerBox\" style=\"display: flex;\">\r\n"
				+ "					<div class=\"playerImg\"></div>\r\n"
				+ "					<div class=\"playerDetails\">\r\n"
				+ "						<div class=\"playerDesc\">\r\n"
				+ "							<div class=\"playerNum\"><span>Jersey</span><span>#" + threes.getPlayerId().getJerseyNumber() + "</span></div>\r\n"
				+ "							<div class=\"playerNameBox\">\r\n"
				+ "								<div class=\"playerName\">" + threes.getPlayerId().getFullName() + "</div>\r\n"
				+ "								<div class=\"playerTeamBox\">\r\n"
				+ "									<div class=\"playerPos\">" + threes.getPlayerId().getPosition() + "</div>\r\n"
				+ "									<div class=\"playerTeamName\">" + threes.getPlayerId().getTeam().getName() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "						<div class=\"playerStats\">\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">3PntEff</div>\r\n"
				+ "									<div class=\"playerStat big\">" + threes.getThreePointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">2PntEff</div>\r\n"
				+ "									<div class=\"playerStat\">" + threes.getTwoPointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Eff</div>\r\n"
				+ "									<div class=\"playerStat\">" + threes.getEfficieny() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Assists</div>\r\n"
				+ "									<div class=\"playerStat\">" + threes.getAssists() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Steals</div>\r\n"
				+ "									<div class=\"playerStat\">" + threes.getSteals() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Blocks</div>\r\n"
				+ "									<div class=\"playerStat\">" + threes.getBlocks() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "					\r\n"
				+ "					</div>\r\n"
				+ "				\r\n"
				+ "				</div>\r\n"
				+ "			</div>");
		
		return threesDisplay.toString();
	}
	
	public String getBestTwoDisplay() {
		StringBuilder twosDisplay = new StringBuilder();
		
		PlayerStats stats = imp.getBestTwoPntEff();
		
		twosDisplay.append("			<div class=\"player\" style=\"display: flex;\">\r\n"
				+ "				<div class=\"playerBox\" style=\"display: flex;\">\r\n"
				+ "					<div class=\"playerImg\"></div>\r\n"
				+ "					<div class=\"playerDetails\">\r\n"
				+ "						<div class=\"playerDesc\">\r\n"
				+ "							<div class=\"playerNum\"><span>Jersey</span><span>#" + stats.getPlayerId().getJerseyNumber() + "</span></div>\r\n"
				+ "							<div class=\"playerNameBox\">\r\n"
				+ "								<div class=\"playerName\">" + stats.getPlayerId().getFullName() + "</div>\r\n"
				+ "								<div class=\"playerTeamBox\">\r\n"
				+ "									<div class=\"playerPos\">" + stats.getPlayerId().getPosition() + "</div>\r\n"
				+ "									<div class=\"playerTeamName\">" + stats.getPlayerId().getTeam().getName() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "						<div class=\"playerStats\">\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">3PntEff</div>\r\n"
				+ "									<div class=\"playerStat \">" + stats.getThreePointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">2PntEff</div>\r\n"
				+ "									<div class=\"playerStat big\">" + stats.getTwoPointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Eff</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getEfficieny() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Assists</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getAssists() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Steals</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getSteals() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Blocks</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getBlocks() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "					\r\n"
				+ "					</div>\r\n"
				+ "				\r\n"
				+ "				</div>\r\n"
				+ "			</div>");
		
		return twosDisplay.toString();
	}
	
	public String getBestEffDisplay() {
		StringBuilder display = new StringBuilder();
		
		PlayerStats stats = imp.getBestEff();
		
		display.append("			<div class=\"player\" style=\"display: flex;\">\r\n"
				+ "				<div class=\"playerBox\" style=\"display: flex;\">\r\n"
				+ "					<div class=\"playerImg\"></div>\r\n"
				+ "					<div class=\"playerDetails\">\r\n"
				+ "						<div class=\"playerDesc\">\r\n"
			    + "							<div class=\"playerNum\"><span>Jersey</span><span>#" + stats.getPlayerId().getJerseyNumber() + "</span></div>\r\n"
				+ "							<div class=\"playerNameBox\">\r\n"
				+ "								<div class=\"playerName\">" + stats.getPlayerId().getFullName() + "</div>\r\n"
				+ "								<div class=\"playerTeamBox\">\r\n"
				+ "									<div class=\"playerPos\">" + stats.getPlayerId().getPosition() + "</div>\r\n"
				+ "									<div class=\"playerTeamName\">" + stats.getPlayerId().getTeam().getName() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "						<div class=\"playerStats\">\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">3PntEff</div>\r\n"
				+ "									<div class=\"playerStat \">" + stats.getThreePointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">2PntEff</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getTwoPointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Eff</div>\r\n"
				+ "									<div class=\"playerStat big\">" + stats.getEfficieny() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Assists</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getAssists() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Steals</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getSteals() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Blocks</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getBlocks() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "					\r\n"
				+ "					</div>\r\n"
				+ "				\r\n"
				+ "				</div>\r\n"
				+ "			</div>");
		
		return display.toString();
	}
	
	public String getBestAssistsDisplay() {
		StringBuilder display = new StringBuilder();
		
		PlayerStats stats = imp.getBestAssist();
		
		display.append("			<div class=\"player\" style=\"display: flex;\">\r\n"
				+ "				<div class=\"playerBox\" style=\"display: flex;\">\r\n"
				+ "					<div class=\"playerImg\"></div>\r\n"
				+ "					<div class=\"playerDetails\">\r\n"
				+ "						<div class=\"playerDesc\">\r\n"
				+ "							<div class=\"playerNum\"><span>Jersey</span><span>#" + stats.getPlayerId().getJerseyNumber() + "</span></div>\r\n"
				+ "							<div class=\"playerNameBox\">\r\n"
				+ "								<div class=\"playerName\">" + stats.getPlayerId().getFullName() + "</div>\r\n"
				+ "								<div class=\"playerTeamBox\">\r\n"
				+ "									<div class=\"playerPos\">" + stats.getPlayerId().getPosition() + "</div>\r\n"
				+ "									<div class=\"playerTeamName\">" + stats.getPlayerId().getTeam().getName() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "						<div class=\"playerStats\">\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">3PntEff</div>\r\n"
				+ "									<div class=\"playerStat \">" + stats.getThreePointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">2PntEff</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getTwoPointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Eff</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getEfficieny() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Assists</div>\r\n"
				+ "									<div class=\"playerStat big\">" + stats.getAssists() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Steals</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getSteals() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Blocks</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getBlocks() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "					\r\n"
				+ "					</div>\r\n"
				+ "				\r\n"
				+ "				</div>\r\n"
				+ "			</div>");
		
		return display.toString();
	}
	
	public String getBestStealsDisplay() {
		StringBuilder display = new StringBuilder();
		
		PlayerStats stats = imp.getBestSteals();
		
		display.append("			<div class=\"player\" style=\"display: flex;\">\r\n"
				+ "				<div class=\"playerBox\" style=\"display: flex;\">\r\n"
				+ "					<div class=\"playerImg\"></div>\r\n"
				+ "					<div class=\"playerDetails\">\r\n"
				+ "						<div class=\"playerDesc\">\r\n"
				+ "							<div class=\"playerNum\"><span>Jersey</span><span>#" + stats.getPlayerId().getJerseyNumber() + "</span></div>\r\n"
				+ "							<div class=\"playerNameBox\">\r\n"
				+ "								<div class=\"playerName\">" + stats.getPlayerId().getFullName() + "</div>\r\n"
				+ "								<div class=\"playerTeamBox\">\r\n"
				+ "									<div class=\"playerPos\">" + stats.getPlayerId().getPosition() + "</div>\r\n"
				+ "									<div class=\"playerTeamName\">" + stats.getPlayerId().getTeam().getName() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "						<div class=\"playerStats\">\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">3PntEff</div>\r\n"
				+ "									<div class=\"playerStat \">" + stats.getThreePointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">2PntEff</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getTwoPointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Eff</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getEfficieny() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Assists</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getAssists() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Steals</div>\r\n"
				+ "									<div class=\"playerStat big\">" + stats.getSteals() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Blocks</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getBlocks() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "					\r\n"
				+ "					</div>\r\n"
				+ "				\r\n"
				+ "				</div>\r\n"
				+ "			</div>");
		
		return display.toString();
	}
	
	public String getBestBlocksDisplay() {
		StringBuilder display = new StringBuilder();
		
		PlayerStats stats = imp.getBestBlocks();
		
		display.append("			<div class=\"player\" style=\"display: flex;\">\r\n"
				+ "				<div class=\"playerBox\" style=\"display: flex;\">\r\n"
				+ "					<div class=\"playerImg\"></div>\r\n"
				+ "					<div class=\"playerDetails\">\r\n"
				+ "						<div class=\"playerDesc\">\r\n"
				+ "							<div class=\"playerNum\"><span>Jersey</span><span>#" + stats.getPlayerId().getJerseyNumber() + "</span></div>\r\n"
				+ "							<div class=\"playerNameBox\">\r\n"
				+ "								<div class=\"playerName\">" + stats.getPlayerId().getFullName() + "</div>\r\n"
				+ "								<div class=\"playerTeamBox\">\r\n"
				+ "									<div class=\"playerPos\">" + stats.getPlayerId().getPosition() + "</div>\r\n"
				+ "									<div class=\"playerTeamName\">" + stats.getPlayerId().getTeam().getName() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "						<div class=\"playerStats\">\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">3PntEff</div>\r\n"
				+ "									<div class=\"playerStat \">" + stats.getThreePointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">2PntEff</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getTwoPointerEff() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Eff</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getEfficieny() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "							<div class=\"playerStatsCont\">\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Assists</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getAssists() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Steals</div>\r\n"
				+ "									<div class=\"playerStat\">" + stats.getSteals() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "								<div class=\"playerStatsBox\">\r\n"
				+ "									<div class=\"playerStatsTitle\">Blocks</div>\r\n"
				+ "									<div class=\"playerStat big\">" + stats.getBlocks() + "</div>\r\n"
				+ "								</div>\r\n"
				+ "							</div>\r\n"
				+ "						</div>\r\n"
				+ "					\r\n"
				+ "					</div>\r\n"
				+ "				\r\n"
				+ "				</div>\r\n"
				+ "			</div>");
		
		return display.toString();
	}
	
	

}
