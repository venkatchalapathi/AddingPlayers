package com.example.addingplayers.Models;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.example.addingplayers.PlayerTypeConverters;

import java.util.List;

@Entity(tableName = "team_table")
@TypeConverters(PlayerTypeConverters.class)
public class Team implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long team_id;
    private String team_name;
    private int matches;
    private int matches_won;
    private int matches_lost;

    private List<Player> playersList = null;

    public Team() {
    }

    protected Team(Parcel in) {
        team_id = in.readLong();
        team_name = in.readString();
        matches = in.readInt();
        matches_won = in.readInt();
        matches_lost = in.readInt();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    public long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(long team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getMatches_won() {
        return matches_won;
    }

    public void setMatches_won(int matches_won) {
        this.matches_won = matches_won;
    }

    public int getMatches_lost() {
        return matches_lost;
    }

    public void setMatches_lost(int matches_lost) {
        this.matches_lost = matches_lost;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(team_id);
        dest.writeString(team_name);
        dest.writeInt(matches);
        dest.writeInt(matches_won);
        dest.writeInt(matches_lost);
    }
}
