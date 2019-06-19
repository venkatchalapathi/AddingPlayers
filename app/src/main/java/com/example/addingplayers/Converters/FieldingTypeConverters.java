package com.example.addingplayers.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.addingplayers.Models.Bowling;
import com.example.addingplayers.Models.Fielding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class FieldingTypeConverters {
    @TypeConverter
    public static List<Fielding> stringToFielding(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Fielding>>() {}.getType();
        List<Fielding> measurements = gson.fromJson(json, type);
        return measurements;
    }

    @TypeConverter
    public static String fieldingToString(List<Fielding> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Fielding>>() {}.getType();
        String json = gson.toJson(list, type);
        return json;
    }
}
