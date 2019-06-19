package com.example.addingplayers.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Player {
    @PrimaryKey(autoGenerate = true)
    private int player_id;
    private int team_id;
    private String player_name;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] player_Image;

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
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
}
