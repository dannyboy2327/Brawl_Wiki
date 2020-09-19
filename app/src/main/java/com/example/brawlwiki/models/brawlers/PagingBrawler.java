package com.example.brawlwiki.models.brawlers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PagingBrawler implements Serializable {

    @SerializedName("mCursorsBrawler")
    @Expose
    private CursorsBrawler mCursorsBrawler;
    private final static long serialVersionUID = 3846421576495772418L;

    public CursorsBrawler getCursorsBrawler() {
        return mCursorsBrawler;
    }

    public void setCursorsBrawler(CursorsBrawler cursorsBrawler) {
        this.mCursorsBrawler = cursorsBrawler;
    }
}
