package com.example.brawlwiki.ui.brawlers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BrawlersViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BrawlersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is a brawlers fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}