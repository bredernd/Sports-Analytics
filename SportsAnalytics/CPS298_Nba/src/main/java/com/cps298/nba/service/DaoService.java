package com.cps298.nba.service;

import java.util.List;

import com.cps298.nba.main_entity.GamePrediction;
import com.cps298.nba.main_entity.GameSechedule;
import com.cps298.nba.main_entity.PlayerStats;
import com.cps298.nba.main_entity.TeamPlayers;
import com.cps298.nba.main_entity.TeamRankings;
import com.cps298.nba.main_entity.TeamStats;
import com.cps298.nba.main_entity.Teams;

public interface DaoService {

	 public void saveTeams(List<Teams> teams); // Save a list of teams
	 public Teams getTeam(String teamId); // Retrieve a team by its ID
	 public List<Teams> getAllTeams(); // Retrieve all teams
	
	    public void saveTeamStats(List<TeamStats> teamStats); // Save team stats

	    // Get all team stats
	    List<TeamStats> getAllTeamStats();

	    // Get team stats by team ID
	    TeamStats getTeamStats(String teamId);

	    // Save team rankings
	    void saveTeamRankings(List<TeamRankings> rankings);

	    // Get all team rankings
	    List<TeamRankings> getAllTeamRankings();

	    // Get team rankings by team ID
	    TeamRankings getTeamRankings(String teamId);

	    // Save team players
	    void saveTeamPlayers(List<TeamPlayers> players);

	    // Get all team players
	    List<TeamPlayers> getAllTeamPlayers();

	    // Get team players by team ID
	    List<TeamPlayers> getTeamPlayers(String teamId);

	    // Save player stats
	    void savePlayerStats(List<PlayerStats> stats);

	    // Get all player stats
	    List<PlayerStats> getAllPlayerStats();

	    // Get player stats by player ID
	    PlayerStats getPlayerStats(String playerId);

	    // Save game schedule
	    void saveGameSchedule(List<GameSechedule> schedule);

	    // Get all game schedule
	    List<GameSechedule> getAllGameSchedule();
	    
	    PlayerStats getBestThreePntEff();
	    
		 PlayerStats getBestTwoPntEff();
		 PlayerStats getBestSteals();
		 PlayerStats getBestAssist();
		 PlayerStats getBestBlocks();
		 PlayerStats getBestEff();
		GameSechedule getGameSchedule(int gameId);
		GamePrediction getPrediction(int gameId);
		List<GameSechedule> getGamesByDate(String date);
	

}