package com.cps298.nba.main_entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "GameSchedule")
public class GameSechedule {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int game_id;
	  private String status;
	  private String scheduled;
	  private Integer home_points;
	  private Integer away_points;
	  private Boolean track_on_court;
	  @Column(name = "venue_address")
	  private String venueAddress;
	  @ManyToOne
	  @JoinColumn(name = "home_team_id")
	  private Teams home_team;
	  @ManyToOne
	  @JoinColumn(name = "away_team_id")
	  private Teams away_team;
	  
	  public int getGame_id() {
		return game_id;
	}

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
	public Teams getHome_team() {
		return home_team;
	}
	public void setHome_team(Teams home_team) {
		this.home_team = home_team;
	}
	public Teams getAway_team() {
		return away_team;
	}
	public void setAway_team(Teams away_team) {
		this.away_team = away_team;
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
				+ venueAddress + ", home_team=" + ", away_team=" + "]";
	}
}
