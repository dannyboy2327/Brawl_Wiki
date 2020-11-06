package com.brawl.brawlwiki.database.converters;

import androidx.room.TypeConverter;

import com.brawl.brawlwiki.models.playerranking.PlayerRankingIcon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class IconConverter {

    @TypeConverter
    public static PlayerRankingIcon fromStringToIcon(String value) {

        Type objectType = new TypeToken<PlayerRankingIcon>() {}.getType();

        return new Gson().fromJson(value, objectType);
    }

    @TypeConverter
    public static String fromListToString(PlayerRankingIcon playerRankingIcon) {

        Gson gson = new Gson();

        return gson.toJson(playerRankingIcon);
    }
}
