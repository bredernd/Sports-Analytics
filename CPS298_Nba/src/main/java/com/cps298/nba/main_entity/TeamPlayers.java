package com.cps298.nba.main_entity;

public class TeamPlayers {

	private String teamId;
	private String playerId;
	private String fullName;
	private String position;
	private int jerseyNumber;
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
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
		return "TeamPlayers [teamId=" + teamId + ", playerId=" + playerId + ", fullName=" + fullName + ", position="
				+ position + ", jerseyNumber=" + jerseyNumber + "]";
	}
}
