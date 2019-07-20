package com.example.addingplayers.Database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.addingplayers.Models.Player;
import com.example.addingplayers.Models.Team;
import com.example.addingplayers.Models.TeamWithPlayers;

import java.util.List;

public class ImageViewModel extends AndroidViewModel {
    private ImageRepository imageRepository;
    private LiveData<List<Team>> mlist;
    private LiveData<List<TeamWithPlayers>> playerList;

    public ImageViewModel(Application application) {
        super(application);
        imageRepository = new ImageRepository(application);
        mlist = imageRepository.getAllTeams();
    }

    public LiveData<List<TeamWithPlayers>> getPlayerList(int id) {
        return playerList = imageRepository.getAllPlayers(id);
    }

    public LiveData<List<Team>> getMlist() {
        return mlist;
    }
    public void insert(Team mealInfo){
        imageRepository.insertTeam(mealInfo);
    }
    public void delete(Team mealInfo){
        imageRepository.deleteTeam(mealInfo);
    }


    public void update(Team targetUser) {
        imageRepository.updateTeam(targetUser);
    }

    /*public LiveData<List<Player>> getPlayerList(int id) {
        return imageRepository.getAllPlayers(id);
    }
*/
    public void insertNewPlayer(Player info) {
        imageRepository.insertPlayer(info);
    }

    public byte[] getPlayer(int id) {
       return imageRepository.getPlayer(id);
    }
}
