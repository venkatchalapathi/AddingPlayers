package com.example.addingplayers;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.addingplayers.Models.Player;
import com.example.addingplayers.Models.Team;

import java.util.List;

public class ImageViewModel extends AndroidViewModel {
    private ImageRepository imageRepository;
    private LiveData<List<Team>> mlist;
    private LiveData<List<Player>> playerList;

    public ImageViewModel(Application application) {
        super(application);
        imageRepository = new ImageRepository(application);
        mlist = imageRepository.getAllTeams();
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

    public LiveData<List<Player>> getPlayerList(int id) {
        return imageRepository.getAllPlayers(id);
    }

    public void insertNewPlayer(Player info) {
        imageRepository.insertPlayer(info);
    }
}
