package com.example.brawlwiki.models.gamemodes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GamesModeList implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("list")
    @Expose
    private List<GameMode> mGameModes = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GameMode> getList() {
        return mGameModes;
    }

    public void setList(List<GameMode> gameModes) {
        this.mGameModes = gameModes;
    }
}
