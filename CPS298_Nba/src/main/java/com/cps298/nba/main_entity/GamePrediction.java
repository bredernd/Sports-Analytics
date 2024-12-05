package com.cps298.nba.main_entity;

import java.util.List;
import java.util.Map;

public class GamePrediction {
    private Teams homeTeam;
    private Teams awayTeam;
    private TeamStats homeTeamStats;
    private TeamStats awayTeamStats;
    private Map<TeamPlayers, PlayerStats> homeTopPlayers;
    private Map<TeamPlayers, PlayerStats> awayTopPlayers;
    private double homeWinProbability;
    private double awayWinProbability;
    private int gameRating; // Likert scale 1–10
    private String message;
    // Getters and Setters
    public Teams getHomeTeam() {
        return homeTeam;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setHomeTeam(Teams homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Teams getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Teams awayTeam) {
        this.awayTeam = awayTeam;
    }

    public TeamStats getHomeTeamStats() {
        return homeTeamStats;
    }

    public void setHomeTeamStats(TeamStats homeTeamStats) {
        this.homeTeamStats = homeTeamStats;
    }

    public TeamStats getAwayTeamStats() {
        return awayTeamStats;
    }

    public void setAwayTeamStats(TeamStats awayTeamStats) {
        this.awayTeamStats = awayTeamStats;
    }

    public Map<TeamPlayers, PlayerStats> getHomeTopPlayers() {
		return homeTopPlayers;
	}

	public void setHomeTopPlayers(Map<TeamPlayers, PlayerStats> homeTopPlayers) {
		this.homeTopPlayers = homeTopPlayers;
	}

	public Map<TeamPlayers, PlayerStats> getAwayTopPlayers() {
		return awayTopPlayers;
	}

	public void setAwayTopPlayers(Map<TeamPlayers, PlayerStats> awayTopPlayers) {
		this.awayTopPlayers = awayTopPlayers;
	}

	public double getHomeWinProbability() {
        return homeWinProbability;
    }

    public void setHomeWinProbability(double homeWinProbability) {
        this.homeWinProbability = homeWinProbability;
    }

    public double getAwayWinProbability() {
        return awayWinProbability;
    }

    public void setAwayWinProbability(double awayWinProbability) {
        this.awayWinProbability = awayWinProbability;
    }

    public int getGameRating() {
        return gameRating;
    }

    public void setGameRating(int gameRating) {
        this.gameRating = gameRating;
    }
}
