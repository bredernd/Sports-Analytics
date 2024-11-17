package com.cps298.nba.main_entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teams {

	@Id
	private String teamId;
	private String name;
	private String market;
	
	@OneToMany(mappedBy = "team")
	private List<TeamPlayers> players= new ArrayList<>();
	
	@OneToMany(mappedBy = "home_team")
	private List<GameSechedule> homeGames = new ArrayList<>();
	
	@OneToMany(mappedBy = "away_team")
    private List<GameSechedule> awayGames = new ArrayList<>();
    
	public List<GameSechedule> getHomeGames() {
		return homeGames;
	}
	public void setHomeGames(List<GameSechedule> homeGames) {
		this.homeGames = homeGames;
	}
	public List<GameSechedule> getAwayGames() {
		return awayGames;
	}
	public void setAwayGames(List<GameSechedule> awayGames) {
		this.awayGames = awayGames;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TeamPlayers> getPlayers() {
		return players;
	}
	public void setPlayers(List<TeamPlayers> players) {
		this.players = players;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", name=" + name + ", market=" + market + ", players=" + players
				+ ", homeGames=" + homeGames + ", awayGames=" + awayGames + "]";
	}
	
}
