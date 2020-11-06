package com.brawl.brawlwiki.models.clubranking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ClubMemberList implements Serializable {

    @SerializedName("items")
    @Expose
    private List<ClubRanking> clubRankingList = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;

    public List<ClubRanking> getClubRankingList() {
        return clubRankingList;
    }

    public void setClubRankingList(List<ClubRanking> clubRankingList) {
        this.clubRankingList = clubRankingList;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
