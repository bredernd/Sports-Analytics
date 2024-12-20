package com.cps298.nba.dao;

import java.util.List;

import com.cps298.nba.main_entity.GameSechedule;
import com.cps298.nba.main_entity.PlayerStats;
import com.cps298.nba.main_entity.TeamPlayers;
import com.cps298.nba.main_entity.TeamRankings;
import com.cps298.nba.main_entity.TeamStats;
import com.cps298.nba.main_entity.Teams;

public interface Dao {

	 public void saveTeams(List<Teams> teams); // Save a list of teams
	 public Teams getTeam(String teamId); // Retrieve a team by its ID
	 public List<Teams> getAllTeams(); // Retrieve all teams
	 public void saveTeamStats(List<TeamStats> teamStats);
	 public List<TeamStats> getAllTeamStats();
	 public TeamStats getTeamStats(String teamId);
	 public void saveTeamRankings(List<TeamRankings> rankings);
	 public List<TeamRankings> getAllTeamRankings();
	 public TeamRankings getTeamRankings(String teamId);
	 public void saveTeamPlayers(List<TeamPlayers> players);
	 public List<TeamPlayers> getAllTeamPlayers();
	 public List<TeamPlayers> getTeamPlayers(String teamId);
	 public void savePlayerStats(List<PlayerStats> stats);
	 public List<PlayerStats> getAllPlayerStats();
	 public PlayerStats getPlayerStats(String playerId);
	 public void saveGameSchedule(List<GameSechedule> schedule);
	 public List<GameSechedule> getAllGameSchedule();
	 public GameSechedule getGameSechedule(int gameId);
	 public PlayerStats getBestThreePntEff();
	 public PlayerStats getBestTwoPntEff();
	 public PlayerStats getBestSteals();
	 public PlayerStats getBestAssist();
	 public PlayerStats getBestBlocks();
	 public PlayerStats getBestEff();
	List<GameSechedule> getGamesByDate(String date);
}
