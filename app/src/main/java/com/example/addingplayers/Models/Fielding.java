package com.example.addingplayers.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
public class Fielding {
    @PrimaryKey(autoGenerate = true)
    private int fielding_id;
    private int player_id;
    private int matches;
    private int catches;
    private int stumpings;
    private int run_outs;

    public int getFielding_id() {
        return fielding_id;
    }

    public void setFielding_id(int fielding_id) {
        this.fielding_id = fielding_id;
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

    public int getCatches() {
        return catches;
    }

    public void setCatches(int catches) {
        this.catches = catches;
    }

    public int getStumpings() {
        return stumpings;
    }

    public void setStumpings(int stumpings) {
        this.stumpings = stumpings;
    }

    public int getRun_outs() {
        return run_outs;
    }

    public void setRun_outs(int run_outs) {
        this.run_outs = run_outs;
    }
}
