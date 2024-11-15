package com.cps298.nba.main_entity;


public class GameSechedule {

	  private String status;
	  private String scheduled;
	  private Integer home_points;
	  private Integer away_points;
	  private Boolean track_on_court;
	  private String venueAddress;
	  private String home_team_id; 
	  private String away_team_id;

	public String getScheduled() {
		return scheduled;
	}
	public void setScheduled(String scheduled) {
		this.scheduled = scheduled;
	}
	public Integer getHome_points() {
		return home_points;
	}
	public void setHome_points(Integer home_points) {
		this.home_points = home_points;
	}
	public Integer getAway_points() {
		return away_points;
	}
	public void setAway_points(Integer away_points) {
		this.away_points = away_points;
	}
	public Boolean getTrack_on_court() {
		return track_on_court;
	}
	public void setTrack_on_court(Boolean track_on_court) {
		this.track_on_court = track_on_court;
	}
	public String getVenueAddress() {
		return venueAddress;
	}
	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}
	public String getHome_team_id() {
		return home_team_id;
	}
	public void setHome_team_id(String home_team_id) {
		this.home_team_id = home_team_id;
	}
	public String getAway_team_id() {
		return away_team_id;
	}
	public void setAway_team_id(String away_team_id) {
		this.away_team_id = away_team_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    @Override
	public String toString() {
		return "GameSechedule [status=" + status + ", scheduled=" + scheduled + ", home_points=" + home_points
				+ ", away_points=" + away_points + ", track_on_court=" + track_on_court + ", venueAddress="
				+ venueAddress + ", home_team_id=" + home_team_id + ", away_team_id=" + away_team_id + "]";
	}
}
