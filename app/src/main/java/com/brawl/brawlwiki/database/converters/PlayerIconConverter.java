package com.brawl.brawlwiki.database.converters;

import androidx.room.TypeConverter;

import com.brawl.brawlwiki.models.profile.PlayerIcon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class PlayerIconConverter {

    @TypeConverter
    public static PlayerIcon fromStringToPlayerIcon(String value) {

        Type objectType = new TypeToken<PlayerIcon>() {}.getType();

        return new Gson().fromJson(value, objectType);
    }

    @TypeConverter
    public static String fromObjectToString(PlayerIcon playerIcon) {

        Gson gson = new Gson();

        return gson.toJson(playerIcon);
    }
}
