package com.cps298.nba.service;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cps298.nba.entity.GameResponse;
import com.cps298.nba.entity.PlayerResponse;
import com.cps298.nba.entity.Rankings;
import com.cps298.nba.entity.TeamStatsResponse;
import com.cps298.nba.main_entity.GameSechedule;
import com.cps298.nba.main_entity.PlayerStats;
import com.cps298.nba.main_entity.TeamPlayers;
import com.cps298.nba.main_entity.TeamRankings;
import com.cps298.nba.main_entity.TeamStats;
import com.cps298.nba.main_entity.Teams;

@Service
public class ApiServiceImp implements ApiService {
	
	@Autowired
	DaoService service;

    private RestTemplate restTemplate = new RestTemplate();
    private List<Teams> teamData = new ArrayList<>();
    private List<TeamStats> teamStats = new ArrayList<>();
    private List<TeamRankings> rankings = new ArrayList<>();
    private List<TeamPlayers> teamPlayers = new ArrayList<>();
    private List<PlayerStats> playerStatistics = new ArrayList<>();
    private List<GameSechedule> sechedule = new ArrayList<>();
    

    
    
    // API CALL TO FETCH TEAM DATA AND RANKS AS WELL
    public  List<TeamRankings> fetchRanking() throws InterruptedException {
    	 String url = "https://api.sportradar.com/nba/trial/v8/en/seasons/2024/REG/rankings.json?api_key=";
         String apiKey = "quoLOuR9M3y7o6xB0b4YHMSEU1zkxYyP1KCDyCqJ";
         String uri = url + apiKey;
         
         Rankings response = restTemplate.getForObject(uri, Rankings.class);
         System.out.println(response);
         
         teamData =  fetchTeams(response);
         System.out.println(service);
         //service.saveTeams(teamData);
         
         
         //rankings = fetchTeamRankings(response);
         //service.saveTeamRankings(rankings);
         
         
       //  fetchPlayers(teamData.get(0));
       //  System.out.println(fetchTeamStat(teamData.get(0)));
         
         
         
//         for(Teams team : teamData) {
//        	 System.out.println(team);
//        	 fetchTeamStat(team);
//        	 //fetchPlayers(team);
//        	 Thread.sleep(5000);
//        	 
//         }
         
//         service.saveTeamStats(teamStats);
         //service.saveTeamPlayers(teamPlayers);
        // service.savePlayerStats(playerStatistics);
         
        // gameSechdule();
        // service.saveGameSchedule(sechedule);
         
    	 
    	 return null;
      //   return teamPlayers;
    }
    
    
 // METHOD TO POPUALATE TeamRankings CLASS TO PUT IN DB  
 private List<TeamRankings> fetchTeamRankings(Rankings response) {
	 List<TeamRankings> rankingsList = new ArrayList<>();
	 Map<String, Teams> teamIdToTeamMap = teamData.stream()
             .collect(Collectors.toMap(Teams::getTeamId, team -> team));

	    if (response != null && response.getConferences() != null) {
	        for (Rankings.Conference conference : response.getConferences()) {
	            if (conference.getDivisions() != null) {
	                for (Rankings.Division division : conference.getDivisions()) {
	                    if (division.getTeams() != null) {
	                        for (Rankings.Team team : division.getTeams()) {
	                            // Create a Rankings object and populate it
	                            TeamRankings ranking = new TeamRankings();
	                            ranking.setTeamId(teamIdToTeamMap.get(team.getId()));
	                            ranking.setConference(conference.getName());
	                            ranking.setDivision(division.getName());
	                            ranking.setConferenceRank(team.getRank().getConference());
	                            ranking.setDivisionRank(team.getRank().getDivision());

	                            // Add to the list
	                            rankingsList.add(ranking);
	                        }
	                    }
	                }
	            }
	        }
	    }

	    // Print or log the rankings list to verify
	    System.out.println("Parsed Rankings List: " + rankingsList);

	    return rankingsList;
	}

 // METHOD TO POPULATE Teams CLASS TO PUT IN DB
private List<Teams> fetchTeams(Rankings response) {
	 // Create a list to hold Teams objects
	    List<Teams> teamsList = new ArrayList<>();

	    if (response != null && response.getConferences() != null) {
	        for (Rankings.Conference conference : response.getConferences()) {
	            if (conference.getDivisions() != null) {
	                for (Rankings.Division division : conference.getDivisions()) {
	                    if (division.getTeams() != null) {
	                        for (Rankings.Team team : division.getTeams()) {
	                            // Create a Teams object and populate it
	                            Teams teams = new Teams();
	                            teams.setTeamId(team.getId());
	                            teams.setName(team.getName());
	                            teams.setMarket(team.getMarket());

	                            // Add to the list
	                            teamsList.add(teams);
	                        }
	                    }
	                }
	            }
	        }
	    }

	    // Print or log the teams list to verify
	    System.out.println("Parsed Teams List: " + teamsList);

	    return teamsList;
	}
    
    // API CALL TO FETCH GAME SECHEDULE
public List<Teams> gameSechdule() {
    String url = "https://api.sportradar.com/nba/trial/v8/en/games/2024/REG/schedule.json?api_key=";
    String apiKey = "quoLOuR9M3y7o6xB0b4YHMSEU1zkxYyP1KCDyCqJ";
    String uri = url + apiKey;
    GameResponse response = restTemplate.getForObject(uri, GameResponse.class);

    if (response != null && response.getGames() != null) {
        // Create a map for quick lookup of Teams by their IDs
        Map<String, Teams> teamIdToTeamsMap = teamData.stream()
                .collect(Collectors.toMap(Teams::getTeamId, team -> team));
        
        System.out.println(teamIdToTeamsMap);

        // Filter games scheduled for November and map them to GameSechedule objects
        sechedule = response.getGames().stream()
                .filter(game -> isInNovember(game.getScheduled()))
                .map(game -> mapToGameSechedule(game, teamIdToTeamsMap))
                .collect(Collectors.toList());
        
        //return sechedule;
        return teamData;
    }

    return List.of();
}

    
//Updated mapToGameSechedule to include Teams association
private GameSechedule mapToGameSechedule(GameResponse.Game game, Map<String, Teams> teamIdToTeamsMap) {
 GameSechedule gameSchedule = new GameSechedule();

 gameSchedule.setStatus(game.getStatus());
 gameSchedule.setScheduled(game.getScheduled());
 gameSchedule.setHome_points(game.getHome_points());
 gameSchedule.setAway_points(game.getAway_points());
 gameSchedule.setTrack_on_court(game.getTrack_on_court());

 // Map venue information
 if (game.getVenue() != null) {
     gameSchedule.setVenueAddress(String.format(
         "%s, %s, %s",
         game.getVenue().getName(),
         game.getVenue().getCity(),
         game.getVenue().getAddress()
     ));
 }

 // Map home and away teams using the team ID map
 if (game.getHome() != null) {
	 Teams homeTeam = teamIdToTeamsMap.getOrDefault(game.getHome().getId(), null);
	 if (homeTeam == null) {
		 System.out.println(game);
	 }
     gameSchedule.setHome_team(homeTeam);
     homeTeam.getHomeGames().add(gameSchedule);
 }
 if (game.getAway() != null) {
	 Teams awayTeam = teamIdToTeamsMap.getOrDefault(game.getAway().getId(), null);
     gameSchedule.setAway_team(awayTeam);
     awayTeam.getAwayGames().add(gameSchedule);
 }

 return gameSchedule;
}

    
    // 	API CALL TO FETCH TEAM STATS. THIS API CALL TAKES IN TEAM-ID TO GET DATA
    public TeamStats fetchTeamStat(Teams teamId){
    	String url = "https://api.sportradar.com/nba/trial/v8/en/seasons/2024/REG/teams/"+teamId.getTeamId()+"/statistics.json?api_key=";
        String apiKey = "quoLOuR9M3y7o6xB0b4YHMSEU1zkxYyP1KCDyCqJ";
        String uri = url + apiKey;
        TeamStatsResponse response = restTemplate.getForObject(uri, TeamStatsResponse.class);
        System.out.println("in api = "+ response.toString());
        teamStats.add(getTeamStats(response, teamId));
        return null;
    }
    
    private TeamStats getTeamStats(TeamStatsResponse response, Teams teamId) {
        // Map data to TeamStats object
        TeamStats teamStats = new TeamStats();
        teamStats.setTeamId(teamId);

        TeamStatsResponse.OwnRecord ownRecord = response.getOwn_record();

        // Map Total stats
        if (ownRecord.getTotal() != null) {
            TeamStatsResponse.OwnRecord.Total total = ownRecord.getTotal();
            teamStats.setPossessions(total.getPossessions());
            teamStats.setOpponent_possessions(total.getOpponent_possessions());
            teamStats.setOffensive_rating(total.getOffensive_rating());
            teamStats.setDefensive_rating(total.getDefensive_rating());
            teamStats.setNet_rating(total.getNet_rating());
        }

        // Map Average stats
        if (ownRecord.getAverage() != null) {
            TeamStatsResponse.OwnRecord.Average average = ownRecord.getAverage();
            teamStats.setThree_points_made(average.getThree_points_made());
            teamStats.setThree_points_att(average.getThree_points_att());
            teamStats.setFree_throws_made(average.getFree_throws_made());
            teamStats.setFree_throws_att(average.getFree_throws_att());
            teamStats.setTwo_points_made(average.getTwo_points_made());
            teamStats.setTwo_points_att(average.getTwo_points_att());
            teamStats.setEfficiency(average.getEfficiency());
            teamStats.setRebounds(average.getRebounds());
            teamStats.setAssists(average.getAssists());
            teamStats.setSteals(average.getSteals());
            teamStats.setBlocks(average.getBlocks());
        }

        // Print or log the resulting team stats
        System.out.println("Mapped Team Stats: " + teamStats);

        return teamStats;
	}


	// API CALL TO FETCH PLAYER DETAILS AND THEIR STATS. THIS API CALL TAKES IN TEAM-ID TO GET DATA
    public List<PlayerStats> fetchPlayers(Teams team){
    	String url = "https://api.sportradar.com/nba/trial/v8/en/seasons/2024/REG/teams/"+team.getTeamId()+"/statistics.json?api_key=";
        String apiKey = "quoLOuR9M3y7o6xB0b4YHMSEU1zkxYyP1KCDyCqJ";
        String uri = url + apiKey;
        PlayerResponse response = restTemplate.getForObject(uri, PlayerResponse.class);
        System.out.println("in api = "+ response.toString());
        System.out.println(fetchPlayerDetails(response, team));;
        System.out.println(fetchPlayerStats(response, team));;
        return null;
    }
    
    private List<PlayerStats> fetchPlayerStats(PlayerResponse response, Teams team) {

        if (response != null && response.getPlayers() != null) {
            for (PlayerResponse.Player player : response.getPlayers()) {
                if (player.getAverage() != null) {
                    // Create a PlayerStats object
                    PlayerStats playerStats = new PlayerStats();
                    // Map data from API response
                    playerStats.setPlayerId(findTeamPlayerById(player.getId(), team.getPlayers()));
                    playerStats.setThreePointerEff(player.getAverage().getThree_points_made());
                    playerStats.setTwoPointerEff(player.getAverage().getTwo_points_made());
                    playerStats.setEfficieny(player.getAverage().getEfficiency());
                    playerStats.setAssists(player.getAverage().getAssists());
                    playerStats.setSteals(player.getAverage().getSteals());
                    playerStats.setBlocks(player.getAverage().getBlocks());

                    // Add to the list
                    playerStatistics.add(playerStats);
                }
            }
        }

        // Print or log the playerStats list to verify
        System.out.println("Parsed Player Statistics List: " + playerStatistics);

        return playerStatistics;
	}


	private List<TeamPlayers> fetchPlayerDetails(PlayerResponse response, Teams team) {
    	
    	if (response != null && response.getPlayers() != null) {
            for (PlayerResponse.Player player : response.getPlayers()) {
                // Create a TeamPlayers object
                TeamPlayers teamPlayer = new TeamPlayers();

                // Map data from API response
                teamPlayer.setTeam(team); // Use the provided teamId
                teamPlayer.setPlayerId(player.getId());
                teamPlayer.setFullName(player.getFull_name());
                teamPlayer.setPosition(player.getPrimary_position());
                teamPlayer.setJerseyNumber(player.getJersey_number());
                // Add to the list
                teamPlayers.add(teamPlayer);
            }
            
            team.setPlayers(teamPlayers);
        }

        // Print or log the teamPlayers list to verify
        System.out.println("Parsed Team Players List: " + teamPlayers);

        return teamPlayers;	}
	
	private TeamPlayers findTeamPlayerById(String playerId, List<TeamPlayers> teamPlayers) {
	    for (TeamPlayers teamPlayer : teamPlayers) {
	        if (teamPlayer.getPlayerId().equals(playerId)) {
	            return teamPlayer;
	        }
	    }
	    return null; // Return null if no matching player found
	}

	// METHOD USED WITHIN THE API TO PARSE THE GAME SECHEDULE AND TO ONLY RETURN GAMES PLAYER IN NOVEMBER
    private boolean isInNovember(String scheduled) {
        try {
            // Extract and parse the date from the scheduled field
            LocalDate gameDate = LocalDate.parse(scheduled.substring(0, 10)); // "2024-11-10T23:30:00Z" -> "2024-11-10"
            LocalDate startOfNovember = LocalDate.of(LocalDate.now().getYear(), 11, 1);
            LocalDate endOfNovember = LocalDate.of(LocalDate.now().getYear(), 12, 9);

            return !gameDate.isBefore(startOfNovember) && !gameDate.isAfter(endOfNovember);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
