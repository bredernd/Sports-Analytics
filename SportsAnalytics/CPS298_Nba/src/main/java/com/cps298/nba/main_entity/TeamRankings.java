package com.cps298.nba.main_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TeamRankings {

	@Id
	@ManyToOne
	@JoinColumn(name="teamId")
	private Teams teamId;
	private String conference;
	private String division;
	private int conferenceRank;
	private int divisionRank;
	public Teams getTeamId() {
		return teamId;
	}
	public void setTeamId(Teams teamId) {
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
