package com.example.addingplayers.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.addingplayers.ImageInfo;
import com.example.addingplayers.Models.Batting;
import com.example.addingplayers.Models.Bowling;
import com.example.addingplayers.Models.Fielding;
import com.example.addingplayers.Models.Player;
import com.example.addingplayers.Models.Team;
import com.example.addingplayers.Models.TeamWithPlayers;

import java.util.List;

public class ImageRepository {
    private ImageDao mMealDao;
    private LiveData<List<ImageInfo>> mAllMeals;
    private LiveData<List<Team>> allTeams;
    private LiveData<List<Team>> selectedTeam;
    private LiveData<List<Player>> allPlayers;

    public ImageRepository(Application application) {
        ImageDatabase database = ImageDatabase.getDatabase(application);
        mMealDao = database.imageDao();
        mAllMeals = mMealDao.getAllFavs();
        allTeams = mMealDao.getAllTeams();
    }

    public LiveData<List<ImageInfo>> getmAllMeals() {
        return mAllMeals;
    }

    public LiveData<List<Team>> getAllTeams() {
        return mMealDao.getAllTeams();
    }

   /* public LiveData<List<Team>> getSelectedTeam(int id) {
        return mMealDao.getSelectedTeam(id);
    }*/

    public LiveData<List<TeamWithPlayers>> getAllPlayers(int id) {
        return mMealDao.getPlayers(id);
    }

    void insertTeam(Team word) {
        new insertAsyncTask(mMealDao).execute(word);
    }

    void insertPlayer(Player player) {
        new insertPlayerTask(mMealDao).execute(player);
    }

    void updateBatting(Batting batting) {
        new updateBattingTask(mMealDao).execute(batting);
    }

    void updateBowling(Bowling bowling) {
        new updateBowlingTask(mMealDao).execute(bowling);
    }

    void updateFielding(Fielding fielding) {
        new updateFieldingTask(mMealDao).execute(fielding);

    }

    void deleteTeam(Team word) {
        new deleteAsyncTask(mMealDao).execute(word);

    }

    void deletePlayer(Player player) {
        new deletePlayerTask(mMealDao).execute(player);

    }

    void updatePlayer(Player player) {
        new updatePlayerTask(mMealDao).execute(player);

    }

    public void updateTeam(Team targetUser) {
        new updateAsyncTask(mMealDao).execute(targetUser);
    }

    public byte[] getPlayer(int id) {
        return mMealDao.getPlayer(id);
    }

    private static class insertAsyncTask extends AsyncTask<Team, Void, Void> {

        private ImageDao mAsyncTaskDao;

        insertAsyncTask(ImageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Team... params) {
            mAsyncTaskDao.insertNeaTeam(params[0]);
            return null;
        }
    }

    private static class insertPlayerTask extends AsyncTask<Player, Void, Void> {

        private ImageDao mAsyncTaskDao;

        insertPlayerTask(ImageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Player... params) {
            /*daredao().insertAll(new Team("dare_title1", params[0].getPlayer_name()));
            stepdao().insertAll(steps[0]);*/
            mAsyncTaskDao.insertNewPlayer(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Team, Void, Void> {

        private ImageDao mAsyncTaskDao;

        deleteAsyncTask(ImageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Team... params) {
            mAsyncTaskDao.deleteTeam(params[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<Team, Void, Void> {

        private ImageDao mAsyncTaskDao;

        updateAsyncTask(ImageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Team... params) {
            mAsyncTaskDao.updateTeam(params[0]);
            return null;
        }
    }

    private static class updateBattingTask extends AsyncTask<Batting, Void, Void> {

        private ImageDao mAsyncTaskDao;

        updateBattingTask(ImageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Batting... params) {
            mAsyncTaskDao.updateBatting(params[0]);
            return null;
        }
    }

    private static class updateBowlingTask extends AsyncTask<Bowling, Void, Void> {

        private ImageDao mAsyncTaskDao;

        updateBowlingTask(ImageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Bowling... params) {
            mAsyncTaskDao.updateBowling(params[0]);
            return null;
        }
    }

    private static class updateFieldingTask extends AsyncTask<Fielding, Void, Void> {

        private ImageDao mAsyncTaskDao;

        updateFieldingTask(ImageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Fielding... params) {
            mAsyncTaskDao.updateFielding(params[0]);
            return null;
        }
    }

    private static class deletePlayerTask extends AsyncTask<Player, Void, Void> {

        private ImageDao mAsyncTaskDao;

        deletePlayerTask(ImageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Player... params) {
            mAsyncTaskDao.deletePlayer(params[0]);
            return null;
        }
    }

    private static class updatePlayerTask extends AsyncTask<Player, Void, Void> {

        private ImageDao mAsyncTaskDao;

        updatePlayerTask(ImageDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Player... params) {
            mAsyncTaskDao.updatePlayer(params[0]);
            return null;
        }
    }
}
