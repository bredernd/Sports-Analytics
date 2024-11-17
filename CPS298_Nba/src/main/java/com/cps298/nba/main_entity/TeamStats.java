package com.cps298.nba.main_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TeamStats {

	@Id
	@ManyToOne
	@JoinColumn(name="teamId")
	private Teams teamId;
	//THE FOLLOWING ARE TO BE RETRIVED FROM TOTAL OBJECT
    private Double possessions;
    private Double opponent_possessions;
    private Double offensive_rating;
    private Double defensive_rating;
    private Double net_rating;
    
    // FOLLWING TO BE RETRIVED FROM AVERAGE OBJECT
    private Double three_points_made;
    private Double three_points_att;
    private Double free_throws_made;
    private Double free_throws_att;
    private Double two_points_made;
    private Double two_points_att;
    private Double efficiency;
    private Double rebounds;
    private Double assists;
    private Double steals;
    private Double blocks;
	public Teams getTeamId() {
		return teamId;
	}
	public void setTeamId(Teams teamId) {
		this.teamId = teamId;
	}
	public Double getPossessions() {
		return possessions;
	}
	public void setPossessions(Double possessions) {
		this.possessions = possessions;
	}
	public Double getOpponent_possessions() {
		return opponent_possessions;
	}
	public void setOpponent_possessions(Double opponent_possessions) {
		this.opponent_possessions = opponent_possessions;
	}
	public Double getOffensive_rating() {
		return offensive_rating;
	}
	public void setOffensive_rating(Double offensive_rating) {
		this.offensive_rating = offensive_rating;
	}
	public Double getDefensive_rating() {
		return defensive_rating;
	}
	public void setDefensive_rating(Double defensive_rating) {
		this.defensive_rating = defensive_rating;
	}
	public Double getNet_rating() {
		return net_rating;
	}
	public void setNet_rating(Double net_rating) {
		this.net_rating = net_rating;
	}
	public Double getThree_points_made() {
		return three_points_made;
	}
	public void setThree_points_made(Double three_points_made) {
		this.three_points_made = three_points_made;
	}
	public Double getThree_points_att() {
		return three_points_att;
	}
	public void setThree_points_att(Double three_points_att) {
		this.three_points_att = three_points_att;
	}
	public Double getFree_throws_made() {
		return free_throws_made;
	}
	public void setFree_throws_made(Double free_throws_made) {
		this.free_throws_made = free_throws_made;
	}
	public Double getFree_throws_att() {
		return free_throws_att;
	}
	public void setFree_throws_att(Double free_throws_att) {
		this.free_throws_att = free_throws_att;
	}
	public Double getTwo_points_made() {
		return two_points_made;
	}
	public void setTwo_points_made(Double two_points_made) {
		this.two_points_made = two_points_made;
	}
	public Double getTwo_points_att() {
		return two_points_att;
	}
	public void setTwo_points_att(Double two_points_att) {
		this.two_points_att = two_points_att;
	}
	public Double getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(Double efficiency) {
		this.efficiency = efficiency;
	}
	public Double getRebounds() {
		return rebounds;
	}
	public void setRebounds(Double rebounds) {
		this.rebounds = rebounds;
	}
	public Double getAssists() {
		return assists;
	}
	public void setAssists(Double assists) {
		this.assists = assists;
	}
	public Double getSteals() {
		return steals;
	}
	public void setSteals(Double steals) {
		this.steals = steals;
	}
	public Double getBlocks() {
		return blocks;
	}
	public void setBlocks(Double blocks) {
		this.blocks = blocks;
	}
	@Override
	public String toString() {
		return "TeamStats [teamId=" + teamId.getTeamId() + ", possessions=" + possessions + ", opponent_possessions="
				+ opponent_possessions + ", offensive_rating=" + offensive_rating + ", defensive_rating="
				+ defensive_rating + ", net_rating=" + net_rating + ", three_points_made=" + three_points_made
				+ ", three_points_att=" + three_points_att + ", free_throws_made=" + free_throws_made
				+ ", free_throws_att=" + free_throws_att + ", two_points_made=" + two_points_made + ", two_points_att="
				+ two_points_att + ", efficiency=" + efficiency + ", rebounds=" + rebounds + ", assists=" + assists
				+ ", steals=" + steals + ", blocks=" + blocks + "]";
	}
    
    
}
