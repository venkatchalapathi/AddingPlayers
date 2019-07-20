package com.example.addingplayers.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.addingplayers.ImageInfo;
import com.example.addingplayers.Models.Batting;
import com.example.addingplayers.Models.Bowling;
import com.example.addingplayers.Models.Fielding;
import com.example.addingplayers.Models.Player;
import com.example.addingplayers.Models.Team;
import com.example.addingplayers.Models.TeamWithPlayers;

import java.util.List;

@Dao
public interface ImageDao {

    @Query("Select * from imageinfo order by id")
    LiveData<List<ImageInfo>> getAllFavs();

    @Query("Select * from team")
    LiveData<List<Team>> getAllTeams();

    /*@Query("Select * from team_table where team_id =:id")
    LiveData<List<Team>> getSelectedTeam(int id);
*/
    @Query("Select * from player where team_id =:id")
    LiveData<List<TeamWithPlayers>> getPlayers(int id);

    @Insert
    void insertNeaTeam(Team param);

    @Delete
    void deleteTeam(Team param);

    @Update
    void updateTeam(Team param);

    @Insert
    void insertNewPlayer(Player param);

    @Update
    void updateBatting(Batting param);

    @Update
    void updateBowling(Bowling param);

    @Delete
    void deletePlayer(Player param);

    @Update
    void updateFielding(Fielding param);

    @Update
    void updatePlayer(Player param);

    @Query("Select player_Image from player where player_id=:id")
    byte[] getPlayer(int id);
}
