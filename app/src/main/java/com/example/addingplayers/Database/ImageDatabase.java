package com.example.addingplayers.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.addingplayers.Converters.BattingTypeConverter;
import com.example.addingplayers.Converters.BowlingTypeConverters;
import com.example.addingplayers.Converters.FieldingTypeConverters;
import com.example.addingplayers.Converters.PlayerTypeConverters;
import com.example.addingplayers.ImageInfo;
import com.example.addingplayers.Models.Batting;
import com.example.addingplayers.Models.Bowling;
import com.example.addingplayers.Models.Fielding;
import com.example.addingplayers.Models.Player;
import com.example.addingplayers.Models.Team;

@Database(entities = {ImageInfo.class, Team.class, Player.class, Batting.class, Bowling.class, Fielding.class},version = 7)
@TypeConverters({PlayerTypeConverters.class, BattingTypeConverter.class, BowlingTypeConverters.class, FieldingTypeConverters.class})
public abstract class ImageDatabase extends RoomDatabase {
    private static final String DATABASE = "image_db";
    public abstract ImageDao imageDao();

    private static volatile ImageDatabase INSTANCE;

    static ImageDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ImageDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ImageDatabase.class, DATABASE)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
