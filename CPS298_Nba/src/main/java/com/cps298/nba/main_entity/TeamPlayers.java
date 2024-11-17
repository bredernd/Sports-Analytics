package com.cps298.nba.main_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TeamPlayers {

	@Id
	private String playerId;
	private String fullName;
	private String position;
	private int jerseyNumber;
	
	@ManyToOne
	@JoinColumn(name = "team", referencedColumnName = "teamId")
	private Teams team;
	public Teams getTeam() {
		return team;
	}
	public void setTeam(Teams team) {
		this.team = team;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	@Override
	public String toString() {
		return "TeamPlayers [playerId=" + playerId + ", fullName=" + fullName + ", position=" + position
				+ ", jerseyNumber=" + jerseyNumber + "TeamId=" + team.getTeamId() + "]";
	}
}
