package com.cps298.nba.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cps298.nba.main_entity.GameSechedule;
import com.cps298.nba.main_entity.PlayerStats;
import com.cps298.nba.main_entity.TeamPlayers;
import com.cps298.nba.main_entity.TeamRankings;
import com.cps298.nba.main_entity.TeamStats;
import com.cps298.nba.main_entity.Teams;

@Repository
public class DaoImp implements Dao {

	@Autowired
	public SessionFactory sessionFactory;

	   @Override
	    public void saveTeams(List<Teams> teams) {
	        Session session = sessionFactory.getCurrentSession();
	        for (Teams team : teams) {
	            session.saveOrUpdate(team); // Save or update each team
	        }
	    }

	    @Override
	    public Teams getTeam(String teamId) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.get(Teams.class, teamId); // Retrieve a team by ID
	    }

	    @Override
	    public List<Teams> getAllTeams() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("from Teams", Teams.class).getResultList(); // Retrieve all teams
	    }
	    
	    // Save Team Stats
	    @Override
	    public void saveTeamStats(List<TeamStats> teamStats) {
	        Session session = sessionFactory.getCurrentSession();
	        for (TeamStats stats : teamStats) {
	            session.saveOrUpdate(stats);
	        }
	    }

	    // Get All Team Stats
	    @Override
	    public List<TeamStats> getAllTeamStats() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM TeamStats", TeamStats.class).getResultList();
	    }
	    
	    @Override
	    public TeamStats getTeamStats(String teamId) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.get(TeamStats.class, teamId); // Retrieve a team by ID
	    }
	    
	    // Save Team Rankings
	    @Override
	    public void saveTeamRankings(List<TeamRankings> rankings) {
	        Session session = sessionFactory.getCurrentSession();
	        for (TeamRankings ranking : rankings) {
	            session.saveOrUpdate(ranking);
	        }
	    }

	    // Get All Team Rankings
	    @Override
	    public List<TeamRankings> getAllTeamRankings() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM TeamRankings", TeamRankings.class).getResultList();
	    }
	    
	    @Override
	    public TeamRankings getTeamRankings(String teamId) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.get(TeamRankings.class, teamId); // Retrieve a team by ID
	    }
	    
	 // Save Team Players
	    @Override
	    public void saveTeamPlayers(List<TeamPlayers> players) {
	        Session session = sessionFactory.getCurrentSession();
	        for (TeamPlayers player : players) {
	            session.saveOrUpdate(player);
	        }
	    }

	    // Get All Team Players
	    @Override
	    public List<TeamPlayers> getAllTeamPlayers() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM TeamPlayers", TeamPlayers.class).getResultList();
	    }
	    
	    @Override
	    public List<TeamPlayers> getTeamPlayers(String teamId) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM TeamPlayers WHERE team.teamId = :teamId", TeamPlayers.class)
	                      .setParameter("teamId", teamId)
	                      .getResultList();
	    }
	    
	    // Save Player Stats
	    @Override
	    public void savePlayerStats(List<PlayerStats> stats) {
	        Session session = sessionFactory.getCurrentSession();
	        for (PlayerStats stat : stats) {
	            session.saveOrUpdate(stat);
	        }
	    }

	    // Get All Player Stats
	    @Override
	    public List<PlayerStats> getAllPlayerStats() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM PlayerStats", PlayerStats.class).getResultList();
	    }
	    
	    @Override
	    public PlayerStats getPlayerStats(String playerId) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM PlayerStats WHERE playerId.playerId = :playerId", PlayerStats.class)
	                      .setParameter("playerId", playerId)
	                      .uniqueResult();
	    }
	    
	 // Save Game Schedule
	    @Override
	    public void saveGameSchedule(List<GameSechedule> schedule) {
	        Session session = sessionFactory.getCurrentSession();
	        for (GameSechedule game : schedule) {
	            session.saveOrUpdate(game);
	        }
	    }

	    // Get All Game Schedule
	    @Override
	    public List<GameSechedule> getAllGameSchedule() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM GameSechedule", GameSechedule.class).getResultList();
	    }
	    
	    @Override
	    public PlayerStats getBestThreePntEff() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM PlayerStats ORDER BY threePointerEff DESC", PlayerStats.class)
	                      .setMaxResults(1)
	                      .uniqueResult();
	    }
	    
	    @Override
	    public PlayerStats getBestTwoPntEff() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM PlayerStats ORDER BY twoPointerEff DESC", PlayerStats.class)
	                      .setMaxResults(1)
	                      .uniqueResult();
	    }
	    
	    @Override
	    public PlayerStats getBestEff() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM PlayerStats ORDER BY efficieny DESC", PlayerStats.class)
	                      .setMaxResults(1)
	                      .uniqueResult();
	    }
	    
	    @Override
	    public PlayerStats getBestAssist() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM PlayerStats ORDER BY assists DESC", PlayerStats.class)
	                      .setMaxResults(1)
	                      .uniqueResult();
	    }
	    
	    @Override
	    public PlayerStats getBestSteals() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM PlayerStats ORDER BY steals DESC", PlayerStats.class)
	                      .setMaxResults(1)
	                      .uniqueResult();
	    }
	    
	    @Override
	    public PlayerStats getBestBlocks() {
	        Session session = sessionFactory.getCurrentSession();
	        return session.createQuery("FROM PlayerStats ORDER BY blocks DESC", PlayerStats.class)
	                      .setMaxResults(1)
	                      .uniqueResult();
	    }
	    
	    @Override
	    public GameSechedule getGameSechedule(int gameId) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.get(GameSechedule.class, gameId); // Retrieve a game by ID
	    }
	    
	    @Override
	    public List<GameSechedule> getGamesByDate(String date) {
	        Session session = sessionFactory.getCurrentSession();
	        String query = "FROM GameSechedule gs WHERE gs.scheduled = :gameDate";
	        return session.createQuery(query, GameSechedule.class)
	                      .setParameter("gameDate", date)
	                      .getResultList();
	    }
	
	
}
