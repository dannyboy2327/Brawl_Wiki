package com.brawl.brawlwiki.models.clubranking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Paging implements Serializable {

    @SerializedName("cursors")
    @Expose
    private Cursors cursors;

    public Cursors getCursors() {
        return cursors;
    }

    public void setCursors(Cursors cursors) {
        this.cursors = cursors;
    }
}
