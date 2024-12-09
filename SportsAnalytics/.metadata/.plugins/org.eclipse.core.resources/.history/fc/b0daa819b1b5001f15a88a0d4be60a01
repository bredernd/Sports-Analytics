package com.cps298.nba.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cps298.nba.dao.Dao;
import com.cps298.nba.main_entity.GamePrediction;
import com.cps298.nba.main_entity.GameSechedule;
import com.cps298.nba.main_entity.PlayerStats;
import com.cps298.nba.main_entity.TeamPlayers;
import com.cps298.nba.main_entity.TeamRankings;
import com.cps298.nba.main_entity.TeamStats;
import com.cps298.nba.main_entity.Teams;

import jakarta.transaction.Transactional;

@Service
public class ServiceImp implements DaoService {

    @Autowired
    private Dao teamDAO;

    @Override
    @Transactional
    public void saveTeams(List<Teams> teams) {
        if (teams == null || teams.isEmpty()) {
            throw new IllegalArgumentException("The team list cannot be null or empty.");
        }
        teamDAO.saveTeams(teams); // Save all teams
    }

    @Override
    @Transactional
    public Teams getTeam(String teamId) {
        Teams team = teamDAO.getTeam(teamId);
        if (team == null) {
            System.out.println("No team found with the given ID: " + teamId);
        }
        return team;
    }

    @Override
    @Transactional
    public List<Teams> getAllTeams() {
        return teamDAO.getAllTeams();
    }

	@Override
	@Transactional
	public void saveTeamStats(List<TeamStats> teamStats) {
		if (teamStats == null || teamStats.isEmpty()) {
            throw new IllegalArgumentException("The team stats list cannot be null or empty.");
        }
        teamDAO.saveTeamStats(teamStats);
		
	}

	@Override
	@Transactional
	public List<TeamStats> getAllTeamStats() {
		return teamDAO.getAllTeamStats();
	}

	@Override
	@Transactional
	public TeamStats getTeamStats(String teamId) {
		 if (teamId == null || teamId.trim().isEmpty()) {
	            throw new IllegalArgumentException("The team ID cannot be null or empty.");
	        }
	        return teamDAO.getTeamStats(teamId);
	}

	@Override
	@Transactional
	public void saveTeamRankings(List<TeamRankings> rankings) {
		if (rankings == null || rankings.isEmpty()) {
            throw new IllegalArgumentException("The team rankings list cannot be null or empty.");
        }
        teamDAO.saveTeamRankings(rankings);
		
	}

	@Override
	@Transactional
	public List<TeamRankings> getAllTeamRankings() {
		return teamDAO.getAllTeamRankings();
	}

	@Override
	@Transactional
	public TeamRankings getTeamRankings(String teamId) {
		if (teamId == null || teamId.trim().isEmpty()) {
            throw new IllegalArgumentException("The team ID cannot be null or empty.");
        }
        return teamDAO.getTeamRankings(teamId);

	}

	@Override
	@Transactional
	public void saveTeamPlayers(List<TeamPlayers> players) {
		 if (players == null || players.isEmpty()) {
	            throw new IllegalArgumentException("The team players list cannot be null or empty.");
	        }
	        teamDAO.saveTeamPlayers(players);
		
	}

	@Override
	@Transactional
	public List<TeamPlayers> getAllTeamPlayers() {
		return teamDAO.getAllTeamPlayers();
	}

	@Override
	@Transactional
	public List<TeamPlayers> getTeamPlayers(String teamId) {
		if (teamId == null || teamId.trim().isEmpty()) {
            throw new IllegalArgumentException("The team ID cannot be null or empty.");
        }
        return teamDAO.getTeamPlayers(teamId);
	}

	@Override
	@Transactional
	public void savePlayerStats(List<PlayerStats> stats) {
		if (stats == null || stats.isEmpty()) {
            throw new IllegalArgumentException("The player stats list cannot be null or empty.");
        }
        teamDAO.savePlayerStats(stats);
		
	}

	@Override
	@Transactional
	public List<PlayerStats> getAllPlayerStats() {
		return teamDAO.getAllPlayerStats();
	}

	@Override
	@Transactional
	public PlayerStats getPlayerStats(String playerId) {
		if (playerId == null || playerId.trim().isEmpty()) {
            throw new IllegalArgumentException("The player ID cannot be null or empty.");
        }
        return teamDAO.getPlayerStats(playerId);
	}

	@Override
	@Transactional
	public void saveGameSchedule(List<GameSechedule> schedule) {
		if (schedule == null || schedule.isEmpty()) {
            throw new IllegalArgumentException("The game schedule list cannot be null or empty.");
        }
        teamDAO.saveGameSchedule(schedule);
		
	}

	@Override
	@Transactional
	public List<GameSechedule> getAllGameSchedule() {
		 return teamDAO.getAllGameSchedule();
	}
	
    @Override
    @Transactional
    public PlayerStats getBestThreePntEff() {
        return teamDAO.getBestThreePntEff();
    }
    
    @Override
    @Transactional
    public PlayerStats getBestTwoPntEff() {
        return teamDAO.getBestTwoPntEff();
    }
    
    @Override
    @Transactional
    public PlayerStats getBestEff() {
        return teamDAO.getBestEff();
    }
    
    @Override
    @Transactional
    public PlayerStats getBestAssist() {
        return teamDAO.getBestAssist();
    }
    
    @Override
    @Transactional
    public PlayerStats getBestSteals() {
        return teamDAO.getBestSteals();
    }
    
    @Override
    @Transactional
    public PlayerStats getBestBlocks() {
        return teamDAO.getBestBlocks();
    }
    
	@Override
	@Transactional
	public GameSechedule getGameSchedule(int gameId) {
		 return teamDAO.getGameSechedule(gameId);
	}
    
    
    @Override
	@Transactional
	public GamePrediction getPrediction(int gameId) {
		GameSechedule gameSchedule = teamDAO.getGameSechedule(gameId);
	    Teams homeTeam = gameSchedule.getHome_team();
	    Teams awayTeam = gameSchedule.getAway_team();

	    TeamStats homeTeamStats = getTeamStats(homeTeam.getTeamId());
	    TeamStats awayTeamStats = getTeamStats(awayTeam.getTeamId());
	    
//	    List<TeamPlayers> players = getTeamPlayers(homeTeam.getTeamId());
//	    for(TeamPlayers player : players) {
//	    	System.out.println(teamDAO.getPlayerStats(player.getPlayerId()));
//	    	//System.out.println(player.getPlayerId());
//	    }

	    Map<TeamPlayers, PlayerStats> homeTopPlayers = getTeamPlayers(homeTeam.getTeamId()).stream()
		        .collect(Collectors.toMap(
		            player -> player, // Map key: Player
		            player -> getPlayerStats(player.getPlayerId()) // Map value: PlayerStats
		        ))
		        .entrySet().stream()
		        .filter(entry -> entry.getValue() != null) // Exclude players without stats
		        .sorted((e1, e2) -> Double.compare(
		            e2.getValue().getEfficieny(), // Sort by PlayerStats efficiency in descending order
		            e1.getValue().getEfficieny()
		        ))
		        .limit(3) // Take top 3
		        .collect(Collectors.toMap(
		            Map.Entry::getKey, // Collect the top 3 players and their stats
		            Map.Entry::getValue,
		            (e1, e2) -> e1, // Handle potential conflicts (not expected here)
		            LinkedHashMap::new // Maintain insertion order for the sorted entries
		        ));
	    
	    System.out.println("//////////////////////////////////////////////////////////away");


	    // Get top 3 players with their stats for the away team
	    Map<TeamPlayers, PlayerStats> awayTopPlayers = getTeamPlayers(awayTeam.getTeamId()).stream()
	        .collect(Collectors.toMap(
	            player -> player, // Map key: Player
	            player -> getPlayerStats(player.getPlayerId()) // Map value: PlayerStats
	        ))
	        .entrySet().stream()
	        .filter(entry -> entry.getValue() != null) // Exclude players without stats
	        .sorted((e1, e2) -> Double.compare(
	            e2.getValue().getEfficieny(), // Sort by PlayerStats efficiency in descending order
	            e1.getValue().getEfficieny()
	        ))
	        .limit(3) // Take top 3
	        .collect(Collectors.toMap(
	            Map.Entry::getKey, // Collect the top 3 players and their stats
	            Map.Entry::getValue,
	            (e1, e2) -> e1, // Handle potential conflicts (not expected here)
	            LinkedHashMap::new // Maintain insertion order for the sorted entries
	        ));

	    System.out.println("************************************************************************1");


	    // Calculate player contributions for each team
	    List<PlayerStats> homePlayers = new ArrayList<>(homeTopPlayers.values());
	    List<PlayerStats> awayPlayers = new ArrayList<>(awayTopPlayers.values());
	    double homePlayerContribution = calculatePlayerContribution(homePlayers);
	    double awayPlayerContribution = calculatePlayerContribution(awayPlayers);
	    
	    System.out.println("1111111111111111111111111111111111111111111111111111111111111111111");

	    // Calculate team scores
	    double homeTeamScore = calculateTeamScore(homeTeamStats, homePlayerContribution, true);
	    double awayTeamScore = calculateTeamScore(awayTeamStats, awayPlayerContribution, false);

	    // Win probabilities
	    double totalScore = homeTeamScore + awayTeamScore;
	    double homeWinProbability = (homeTeamScore / totalScore) * 100;
	    double awayWinProbability = (awayTeamScore / totalScore) * 100;


	    // Populate GamePrediction object
	    GamePrediction prediction = new GamePrediction();
	    
	    // Game rating
	    int gameRating = calculateGameRating(homeTeamStats, awayTeamStats, homePlayers, awayPlayers, homeWinProbability, awayWinProbability);

	    if (gameRating >= 8) {
	    	prediction.setMessage("You should definetly watch this game");
	    } else if (gameRating >=5) {
	    	prediction.setMessage("you may watch this game");
	    }
	    else if (gameRating >=3) {
	    	prediction.setMessage("you are better off not watching this game");
	    }
	    else {
	    	prediction.setMessage("Don't watch this game");
	    }
	    
	    prediction.setHomeTeam(homeTeam);
	    prediction.setAwayTeam(awayTeam);
	    prediction.setHomeTeamStats(homeTeamStats);
	    prediction.setAwayTeamStats(awayTeamStats);
	    prediction.setHomeTopPlayers(homeTopPlayers);
	    prediction.setAwayTopPlayers(awayTopPlayers);
	    prediction.setHomeWinProbability(Math.round(homeWinProbability * 100.0) / 100.0);
	    prediction.setAwayWinProbability(Math.round(awayWinProbability * 100.0) / 100.0);
	    prediction.setGameRating(gameRating);
	    
	    System.out.println("*********************************************done");

	    return prediction;
	}

	private double calculatePlayerContribution(List<PlayerStats> players) {
	    double w1 = 0.5, w2 = 0.3, w3 = 0.2; // Example weights
	    return players.stream()
	        .mapToDouble(player -> w1 * player.getThreePointerEff() + w2 * player.getTwoPointerEff() +
	            w3 * (player.getAssists() + player.getSteals() + player.getBlocks()))
	        .sum();
	}

	private double calculateTeamScore(TeamStats stats, double playerContribution, boolean isHome) {
	    double w1 = 0.4, w2 = 0.4, w3 = 0.2; // Example weights
	    double homeAdvantage = isHome ? 10 : 0; // Example home advantage boost
	    return w1 * stats.getNet_rating() +
	           w2 * (stats.getOffensive_rating() + stats.getDefensive_rating()) +
	           w3 * playerContribution + homeAdvantage;
	}

	private int calculateGameRating(TeamStats homeStats, TeamStats awayStats, List<PlayerStats> homePlayers, List<PlayerStats> awayPlayers, double homeWinProbability, double awayWinProbability) {
	    // Calculate absolute difference in Net Rating (handling negative values correctly)
	    double rankDifference = Math.abs(homeStats.getNet_rating() - awayStats.getNet_rating());
	    double netRatingInterest = 0;

	    // Assign interest based on net rating difference
	    if (rankDifference <= 2) {
	        netRatingInterest = 10; // Very close net ratings, highly interesting
	    } else if (rankDifference <= 5) {
	        netRatingInterest = 8;  // Close net ratings, moderately interesting
	    } else if (rankDifference <= 10) {
	        netRatingInterest = 6;  // Somewhat close net ratings
	    } else {
	        netRatingInterest = 4;  // Large net rating difference, low interest
	    }

	    // Conference and Division Rank differences (scaled for interest)
	    int homeConferenceRank = teamDAO.getTeamRankings(homeStats.getTeamId().getTeamId()).getConferenceRank();
	    int awayConferenceRank = teamDAO.getTeamRankings(awayStats.getTeamId().getTeamId()).getConferenceRank();
	    int homeDivisionRank = teamDAO.getTeamRankings(homeStats.getTeamId().getTeamId()).getDivisionRank();
	    int awayDivisionRank = teamDAO.getTeamRankings(awayStats.getTeamId().getTeamId()).getDivisionRank();

	    double rankingInterest = 0;

	    // Conference Rank difference
	    int conferenceRankDifference = Math.abs(homeConferenceRank - awayConferenceRank);
	    if (conferenceRankDifference <= 2) {
	        rankingInterest += 5; // Same conference rank, more interest
	    } else if (conferenceRankDifference <= 4) {
	        rankingInterest += 3; // Close conference rank, somewhat interesting
	    } else {
	        rankingInterest += 1; // Far conference rank, less interesting
	    }

	    // Division Rank difference
	    int divisionRankDifference = Math.abs(homeDivisionRank - awayDivisionRank);
	    if (divisionRankDifference == 0) {
	        rankingInterest += 5; // Same division rank, very interesting
	    } else if (divisionRankDifference == 1) {
	        rankingInterest += 3; // Close division rank, moderately interesting
	    } else {
	        rankingInterest += 1; // Large division rank difference, less interesting
	    }

	    // Calculate Star Power (sum of top 3 players' efficiency, but normalize it)
	    double starPower = homePlayers.stream().mapToDouble(PlayerStats::getEfficieny).sum() +
	                       awayPlayers.stream().mapToDouble(PlayerStats::getEfficieny).sum();

	    // Normalize efficiency, assuming top players contribute most
	    double normalizedStarPower = starPower / 100; // Arbitrary normalization factor for balance
	    
	    double winDifference = Math.abs(homeWinProbability - awayWinProbability);
	    double interest = 0;
	    if (winDifference <= 20.0) {
	    	 interest = 2.0;
	    }

	    // Final Interest Calculation (weight factors can be adjusted)
	    double finalInterest = (netRatingInterest * 0.3) + (rankingInterest * 0.4) + (normalizedStarPower * 0.3) + interest;

	    // Ensure the final interest value does not exceed 10
	    finalInterest = Math.min(finalInterest, 10);

	    // Return as an integer between 1-10
	    return (int) Math.round(finalInterest);
	}
    
	
}
