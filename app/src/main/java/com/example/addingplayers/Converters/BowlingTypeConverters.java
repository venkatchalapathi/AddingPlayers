package com.example.addingplayers.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.addingplayers.Models.Bowling;
import com.example.addingplayers.Models.Player;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class BowlingTypeConverters {
    @TypeConverter
    public static List<Bowling> stringToBowling(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Bowling>>() {}.getType();
        List<Bowling> measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String bowlingToString(List<Bowling> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Bowling>>() {}.getType();
        String json = gson.toJson(list, type);
        return json;
    }
}
