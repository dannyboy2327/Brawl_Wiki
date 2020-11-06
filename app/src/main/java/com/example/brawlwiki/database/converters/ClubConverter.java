package com.example.brawlwiki.database.converters;

import androidx.room.TypeConverter;

import com.example.brawlwiki.models.playerranking.PlayerRankingClub;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ClubConverter {

    @TypeConverter
    public static PlayerRankingClub fromStringToClub(String value) {

        Type objectType = new TypeToken<PlayerRankingClub>() {}.getType();

        return new Gson().fromJson(value, objectType);
    }

    @TypeConverter
    public static String fromObjectToString(PlayerRankingClub playerRankingClub) {

        Gson gson = new Gson();

        return gson.toJson(playerRankingClub);
    }
}
