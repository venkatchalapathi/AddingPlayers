package com.example.addingplayers.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
public class Bowling {
    @PrimaryKey(autoGenerate = true)
    private int bowling_id;
    private int player_id;
    private int matches;
    private int innings;
    private int maidens;
    private int overs;
    private int wickets;
    private int runs;
    private int b_bowling;
    private Double eco_rate;
    private Double average;
    private int wides;
    private int no_balls;
    private int dot_balls;
    private int four_wickets;
    private int five_wickets;

    public int getBowling_id() {
        return bowling_id;
    }

    public void setBowling_id(int bowling_id) {
        this.bowling_id = bowling_id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getInnings() {
        return innings;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }

    public int getMaidens() {
        return maidens;
    }

    public void setMaidens(int maidens) {
        this.maidens = maidens;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getB_bowling() {
        return b_bowling;
    }

    public void setB_bowling(int b_bowling) {
        this.b_bowling = b_bowling;
    }

    public Double getEco_rate() {
        return eco_rate;
    }

    public void setEco_rate(Double eco_rate) {
        this.eco_rate = eco_rate;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public int getWides() {
        return wides;
    }

    public void setWides(int wides) {
        this.wides = wides;
    }

    public int getNo_balls() {
        return no_balls;
    }

    public void setNo_balls(int no_balls) {
        this.no_balls = no_balls;
    }

    public int getDot_balls() {
        return dot_balls;
    }

    public void setDot_balls(int dot_balls) {
        this.dot_balls = dot_balls;
    }

    public int getFour_wickets() {
        return four_wickets;
    }

    public void setFour_wickets(int four_wickets) {
        this.four_wickets = four_wickets;
    }

    public int getFive_wickets() {
        return five_wickets;
    }

    public void setFive_wickets(int five_wickets) {
        this.five_wickets = five_wickets;
    }
}
