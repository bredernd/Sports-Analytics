package com.cps298.nba.main_entity;

public class Teams {

	private String teamId;
	private String name;
	private String market;
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
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", name=" + name + ", market=" + market + "]\n";
	}
	
}
