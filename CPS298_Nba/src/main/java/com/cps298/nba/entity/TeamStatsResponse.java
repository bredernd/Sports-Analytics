package com.cps298.nba.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatsResponse {
    private String id;
    private OwnRecord own_record;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OwnRecord getOwn_record() {
        return own_record;
    }

    public void setOwn_record(OwnRecord own_record) {
        this.own_record = own_record;
    }

    @Override
    public String toString() {
        return "TeamStatsResponse [id=" + id + ", own_record=" + own_record + "]";
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OwnRecord {
        private Total total;
        private Average average;

        // Getters and setters
        public Total getTotal() {
            return total;
        }

        public void setTotal(Total total) {
            this.total = total;
        }

        public Average getAverage() {
            return average;
        }

        public void setAverage(Average average) {
            this.average = average;
        }

        @Override
        public String toString() {
            return "OwnRecord [total=" + total + ", average=" + average + "]";
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Total {
            private Double possessions;
            private Double opponent_possessions;
            private Double offensive_rating;
            private Double defensive_rating;
            private Double net_rating;

            // Getters and setters
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

            @Override
            public String toString() {
                return "Total [possessions=" + possessions + ", opponent_possessions=" + opponent_possessions
                        + ", offensive_rating=" + offensive_rating + ", defensive_rating=" + defensive_rating
                        + ", net_rating=" + net_rating + "]";
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Average {
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

            // Getters and setters
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
                return "Average [three_points_made=" + three_points_made + ", three_points_att=" + three_points_att
                        + ", free_throws_made=" + free_throws_made + ", free_throws_att=" + free_throws_att
                        + ", two_points_made=" + two_points_made + ", two_points_att=" + two_points_att
                        + ", efficiency=" + efficiency + ", rebounds=" + rebounds + ", assists=" + assists
                        + ", steals=" + steals + ", blocks=" + blocks + "]";
            }
        }
    }
}
