	package com.cps298.nba.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerResponse {
    private List<Player> players;

    // Getters and setters
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "PlayerResponse [players=" + players + "]";
    }

    // Inner Player class
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Player {
        private String id;
        private String full_name;
        private String primary_position;
        private int jersey_number;

        private PlayerStats average;

        // Getters and setters
        public String getId() {
            return id;
        }

        public String getFull_name() {
			return full_name;
		}

		public void setFull_name(String full_name) {
			this.full_name = full_name;
		}

		public String getPrimary_position() {
			return primary_position;
		}

		public void setPrimary_position(String primary_position) {
			this.primary_position = primary_position;
		}

		public int getJersey_number() {
			return jersey_number;
		}

		public void setJersey_number(int jersey_number) {
			this.jersey_number = jersey_number;
		}

		public void setId(String id) {
            this.id = id;
        }

        public PlayerStats getAverage() {
            return average;
        }

        public void setAverage(PlayerStats average) {
            this.average = average;
        }

        @Override
        public String toString() {
            return "Player [id=" + id + ", average=" + average + "]";
        }
    }

    // Inner PlayerStats class
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlayerStats {
        private double three_points_made;
        private double two_points_made;
        private double efficiency;
        private double assists;
        private double steals;
        private double blocks;

        // Getters and setters
        public double getThree_points_made() {
            return three_points_made;
        }

        public void setThree_points_made(double three_points_made) {
            this.three_points_made = three_points_made;
        }

        public double getTwo_points_made() {
            return two_points_made;
        }

        public void setTwo_points_made(double two_points_made) {
            this.two_points_made = two_points_made;
        }

        public double getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(double efficiency) {
            this.efficiency = efficiency;
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
            return "PlayerStats [three_points_made=" + three_points_made + ", two_points_made=" + two_points_made
                    + ", efficiency=" + efficiency + ", assists=" + assists + ", steals=" + steals + ", blocks="
                    + blocks + "]";
        }
    }
}
