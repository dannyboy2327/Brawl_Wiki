package com.example.brawlwiki.database.converters;

import androidx.room.TypeConverter;

import com.example.brawlwiki.models.profile.BrawlerStat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class BrawlerStatConverter {

    @TypeConverter
    public static List<BrawlerStat> fromStringToBrawlerStatList(String value) {

        Type listType = new TypeToken<List<BrawlerStat>>() {}.getType();

        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromObjectToString(List<BrawlerStat> brawlerStatList) {

        Gson gson = new Gson();

        return gson.toJson(brawlerStatList);
    }
}
