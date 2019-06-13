package com.example.addingplayers;

import android.os.AsyncTask;

import com.example.addingplayers.Models.Batting;
import com.example.addingplayers.Models.Bowling;
import com.example.addingplayers.Models.Fielding;
import com.example.addingplayers.Models.Player;
import com.example.addingplayers.Models.Team;

public class DBTasks {
    static void insertTeam(Team word, ImageDao imageDao) {

    }

     static void  insertPlayer(Player player,ImageDao imageDao) {

    }

     static void  updateBatting(Batting batting,ImageDao imageDao) {

    }

      static void  updateBowling(Bowling bowling,ImageDao imageDao) {
        }

      static void  updateFielding(Fielding fielding,ImageDao imageDao) {
    }

      static void  deleteTeam(Team word,ImageDao imageDao) {
    }

      static void  deletePlayer(Player player,ImageDao imageDao) {
    }

    static void  updatePlayer(Player player,ImageDao imageDao) {
    }

    static void updateTeam(Team targetUser,ImageDao imageDao) {

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
