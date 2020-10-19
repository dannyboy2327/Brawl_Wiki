package com.example.brawlwiki.database.converters;

import androidx.room.TypeConverter;

import com.example.brawlwiki.models.brawlers.Gadget;
import com.example.brawlwiki.models.brawlers.StarPower;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GadgetConverter {

    @TypeConverter
    public static List<Gadget> fromStringToGadget(String value) {

        Type listType = new TypeToken<List<Gadget>>() {}.getType();

        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromListToString(List<Gadget> list) {

        Gson gson = new Gson();

        return gson.toJson(list);
    }
}
