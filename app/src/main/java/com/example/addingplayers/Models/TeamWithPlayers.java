package com.example.addingplayers.Models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class TeamWithPlayers {
    @Embedded
    public Team team;

    @Relation(parentColumn = "team_id",entityColumn = "team_id",entity = Player.class)
    public List<Player> players;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
