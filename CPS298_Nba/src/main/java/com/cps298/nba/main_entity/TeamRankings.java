package com.cps298.nba.main_entity;

public class TeamRankings {

	private String teamId;
	private String conference;
	private String division;
	private int conferenceRank;
	private int divisionRank;
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getConference() {
		return conference;
	}
	public void setConference(String conference) {
		this.conference = conference;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getConferenceRank() {
		return conferenceRank;
	}
	public void setConferenceRank(int conferenceRank) {
		this.conferenceRank = conferenceRank;
	}
	public int getDivisionRank() {
		return divisionRank;
	}
	public void setDivisionRank(int divisionRank) {
		this.divisionRank = divisionRank;
	}
	@Override
	public String toString() {
		return "Rankings [teamId=" + teamId + ", conference=" + conference + ", division=" + division
				+ ", conferenceRank=" + conferenceRank + ", divisionRank=" + divisionRank + "]";
	}
	
	
}
