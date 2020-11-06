package com.brawl.brawlwiki.database.converters;

import androidx.room.TypeConverter;

import com.brawl.brawlwiki.models.profile.PlayerClub;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class PlayerClubConverter {

    @TypeConverter
    public static PlayerClub fromStringToPlayerClub(String value) {

        Type objectType = new TypeToken<PlayerClub>() {}.getType();

        return new Gson().fromJson(value, objectType);
    }

    @TypeConverter
    public static String fromObjectToString(PlayerClub playerClub) {

        Gson gson = new Gson();

        return gson.toJson(playerClub);
    }
}
