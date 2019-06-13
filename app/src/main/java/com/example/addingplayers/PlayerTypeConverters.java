package com.example.addingplayers;

import android.arch.persistence.room.TypeConverter;

import com.example.addingplayers.Models.Batting;
import com.example.addingplayers.Models.Player;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class PlayerTypeConverters {
    @TypeConverter
    public static List<Batting> stringToMeasurements(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Batting>>() {}.getType();
        List<Batting> measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String measurementsToString(List<Batting> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Batting>>() {}.getType();
        String json = gson.toJson(list, type);
        return json;
    }
}
