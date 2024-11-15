package com.cps298.nba.entity;

import java.util.List;

public class Rankings {

	private List<Conference> conferences;

    // Getter and Setter
    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }
    
    @Override
	public String toString() {
		return "Rankings [conferences=" + conferences + "]";
	}

    public static class Conference {

		private String id;
        private String name;
        private String alias;
        private List<Division> divisions;

        // Getter and Setter
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public List<Division> getDivisions() {
            return divisions;
        }

        public void setDivisions(List<Division> divisions) {
            this.divisions = divisions;
        }
        
        @Override
		public String toString() {
			return "Conference [id=" + id + ", name=" + name + ", alias=" + alias + ", divisions=" + divisions + "]";
		}
    }

    public static class Division {

		private String id;
        private String name;
        private String alias;
        private List<Team> teams;

        // Getter and Setter
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public List<Team> getTeams() {
            return teams;
        }

        public void setTeams(List<Team> teams) {
            this.teams = teams;
        }
        @Override
		public String toString() {
			return "Division [id=" + id + ", name=" + name + ", alias=" + alias + ", teams=" + teams + "]";
		}
    }

    public static class Team {

		private String id;
        private String name;
        private String market;
		private String srId;
        private String reference;
        private Rank rank;

        // Getter and Setter
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getSrId() {
            return srId;
        }

        public void setSrId(String srId) {
            this.srId = srId;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public Rank getRank() {
            return rank;
        }

        public void setRank(Rank rank) {
            this.rank = rank;
        }
        @Override
		public String toString() {
			return "Team [id=" + id + ", name=" + name + ", market=" + market + ", srId=" + srId
					+ ", reference=" + reference + ", rank=" + rank + "]";
		}
    }

    public static class Rank {
        private int conference;
        private int division;

        // Getter and Setter
        public int getConference() {
            return conference;
        }

        public void setConference(int conference) {
            this.conference = conference;
        }

        public int getDivision() {
            return division;
        }

        public void setDivision(int division) {
            this.division = division;
        }

		@Override
		public String toString() {
			return "Rank [conference=" + conference + ", division=" + division + "]";
		}
        
    }
}
