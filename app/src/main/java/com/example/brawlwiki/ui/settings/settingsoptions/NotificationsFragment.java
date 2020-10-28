package com.example.brawlwiki.ui.settings.settingsoptions;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.brawlwiki.R;


public class NotificationsFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences_notifications, rootKey);
    }
    
}