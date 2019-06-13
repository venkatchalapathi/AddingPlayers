package com.example.addingplayers.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Player.class,
        parentColumns = "player_id", childColumns = "batting_id",
        onDelete = CASCADE))
public class Batting {

    private long batting_id;
    @PrimaryKey
    private long player_id;
    private int matches;
    private int innings;
    private int runs;
    private int not_outs;
    private int best_score;
    private Double strike_rate;
    private Double average;
    private int fours;
    private int sixes;
    private int thirties;
    private int fifties;
    private int hundreds;
    private int ducks;
    private int team_id;

    public long getBatting_id() {
        return batting_id;
    }

    public void setBatting_id(long batting_id) {
        this.batting_id = batting_id;
    }

    public long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(long player_id) {
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

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getNot_outs() {
        return not_outs;
    }

    public void setNot_outs(int not_outs) {
        this.not_outs = not_outs;
    }

    public int getBest_score() {
        return best_score;
    }

    public void setBest_score(int best_score) {
        this.best_score = best_score;
    }

    public Double getStrike_rate() {
        return strike_rate;
    }

    public void setStrike_rate(Double strike_rate) {
        this.strike_rate = strike_rate;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getThirties() {
        return thirties;
    }

    public void setThirties(int thirties) {
        this.thirties = thirties;
    }

    public int getFifties() {
        return fifties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    public int getDucks() {
        return ducks;
    }

    public void setDucks(int ducks) {
        this.ducks = ducks;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }
}
