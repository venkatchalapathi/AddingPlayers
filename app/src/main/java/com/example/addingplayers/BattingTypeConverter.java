package com.example.addingplayers;

import android.arch.persistence.room.TypeConverter;

import com.example.addingplayers.Models.Player;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class BattingTypeConverter {
    @TypeConverter
    public static List<Player> stringToMeasurements(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Player>>() {}.getType();
        List<Player> measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String measurementsToString(List<Player> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Player>>() {}.getType();
        String json = gson.toJson(list, type);
        return json;
    }
}
