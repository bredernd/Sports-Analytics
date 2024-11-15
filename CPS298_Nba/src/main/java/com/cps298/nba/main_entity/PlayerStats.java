package com.cps298.nba.main_entity;

public class PlayerStats {

	private String playerId;
	private double threePointerEff;
	private double twoPointerEff;
	private double efficieny;
	private double assists;
	private double steals;
	private double blocks;
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public double getThreePointerEff() {
		return threePointerEff;
	}
	public void setThreePointerEff(double threePointerEff) {
		this.threePointerEff = threePointerEff;
	}
	public double getTwoPointerEff() {
		return twoPointerEff;
	}
	public void setTwoPointerEff(double twoPointerEff) {
		this.twoPointerEff = twoPointerEff;
	}
	public double getEfficieny() {
		return efficieny;
	}
	public void setEfficieny(double efficieny) {
		this.efficieny = efficieny;
	}
	public double getAssists() {
		return assists;
	}
	public void setAssists(double assists) {
		this.assists = assists;
	}
	public double getSteals() {
		return steals;
	}
	public void setSteals(double steals) {
		this.steals = steals;
	}
	public double getBlocks() {
		return blocks;
	}
	public void setBlocks(double blocks) {
		this.blocks = blocks;
	}
	@Override
	public String toString() {
		return "PlayerStats [playerId=" + playerId + ", threePointerEff=" + threePointerEff + ", twoPointerEff="
				+ twoPointerEff + ", efficieny=" + efficieny + ", assists=" + assists + ", steals=" + steals
				+ ", blocks=" + blocks + "]";
	}
}
