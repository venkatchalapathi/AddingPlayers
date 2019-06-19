package com.example.addingplayers.Models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class PlayerWithStats {
    @Embedded
    public Player player;

    @Relation(parentColumn = "player_id",entityColumn = "player_id",
            entity =Batting.class)
    public List<Batting> battingList;

    @Relation(parentColumn = "player_id",entityColumn = "player_id",
            entity = Bowling.class)
    public List<Bowling> bowlingList;

    @Relation(parentColumn = "player_id",entityColumn = "player_id",
            entity = Fielding.class)
    public List<Fielding> fieldingList;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Batting> getBattingList() {
        return battingList;
    }

    public void setBattingList(List<Batting> battingList) {
        this.battingList = battingList;
    }

    public List<Bowling> getBowlingList() {
        return bowlingList;
    }

    public void setBowlingList(List<Bowling> bowlingList) {
        this.bowlingList = bowlingList;
    }

    public List<Fielding> getFieldingList() {
        return fieldingList;
    }

    public void setFieldingList(List<Fielding> fieldingList) {
        this.fieldingList = fieldingList;
    }
}
