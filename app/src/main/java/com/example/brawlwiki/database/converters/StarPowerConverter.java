package com.example.brawlwiki.database.converters;

import androidx.room.TypeConverter;

import com.example.brawlwiki.models.brawlers.StarPower;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class StarPowerConverter {

    @TypeConverter
    public static List<StarPower> fromStringToStarPower(String value) {

        Type listType = new TypeToken<List<StarPower>>() {}.getType();

        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromListToString(List<StarPower> list) {

        Gson gson = new Gson();

        return gson.toJson(list);
    }
}
