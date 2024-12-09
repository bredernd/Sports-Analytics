package com.cps298.nba.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameResponse {

    private List<Game> games;

    @Override
    public String toString() {
        return "GameResponse [games=" + games + "]";
    }

    // Getters and setters
    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Game {
        private String status;
        private String scheduled;
        private Integer home_points;
        private Integer away_points;
        private Boolean track_on_court;
        private Venue venue;
        private Team home; // Map to Team to access nested "id"
        private Team away; // Map to Team to access nested "id"

        @Override
        public String toString() {
            return "Game [status=" + status + ", scheduled=" + scheduled + ", home_points=" + home_points
                    + ", away_points=" + away_points + ", track_on_court=" + track_on_court + ", venue=" + venue
                    + ", home=" + home + ", away=" + away + "]";
        }

        // Getters and setters
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public Venue getVenue() {
            return venue;
        }

        public void setVenue(Venue venue) {
            this.venue = venue;
        }

        public Team getHome() {
            return home;
        }

        public void setHome(Team home) {
            this.home = home;
        }

        public Team getAway() {
            return away;
        }

        public void setAway(Team away) {
            this.away = away;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Venue {
            private String name;
            private String address;
            private String city;
            private String zip;

            @Override
            public String toString() {
                return "Venue [name=" + name + ", address=" + address + ", city=" + city + ", zip=" + zip + "]";
            }

            // Getters and setters
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getZip() {
                return zip;
            }

            public void setZip(String zip) {
                this.zip = zip;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Team {
            private String id;

            @Override
            public String toString() {
                return "Team [id=" + id + "]";
            }

            // Getter and setter
            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
