package com.example.addingplayers.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Player.class,
        parentColumns = "player_id", childColumns = "fielding_id",
        onDelete = CASCADE))
public class Fielding {

    private long fielding_id;
    private long team_id;
    @PrimaryKey
    private long player_id;
    private int matches;
    private int catches;
    private int stumpings;
    private int run_outs;

    public long getFielding_id() {
        return fielding_id;
    }

    public void setFielding_id(long fielding_id) {
        this.fielding_id = fielding_id;
    }

    public long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(long team_id) {
        this.team_id = team_id;
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
