package com.example.addingplayers.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.example.addingplayers.BattingTypeConverter;
import com.example.addingplayers.BowlingTypeConverters;
import com.example.addingplayers.FieldingTypeConverters;

import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Team.class,
        parentColumns = "team_id", childColumns = "player_id",
        onDelete = CASCADE))
public class Player {
    @PrimaryKey
    private long player_id;
    private String player_name;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] player_Image;

    private long team_id;

    private List<Batting> list;
    private List<Bowling> bowlingList;
    private List<Fielding> fieldingList;

    public long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(long player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public byte[] getPlayer_Image() {
        return player_Image;
    }

    public void setPlayer_Image(byte[] player_Image) {
        this.player_Image = player_Image;
    }

    public long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(long team_id) {
        this.team_id = team_id;
    }

    public List<Batting> getList() {
        return list;
    }

    public void setList(List<Batting> list) {
        this.list = list;
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
