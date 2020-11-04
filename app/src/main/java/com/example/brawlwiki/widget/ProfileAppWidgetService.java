package com.example.brawlwiki.widget;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


import androidx.annotation.Nullable;

import com.example.brawlwiki.database.BrawlStarsDatabase;
import com.example.brawlwiki.database.daos.ProfileDao;
import com.example.brawlwiki.models.profile.Player;


public class ProfileAppWidgetService extends IntentService {

    private static final String TAG = ProfileAppWidgetService.class.getSimpleName();

    public static  final String ACTION_UPDATE_TROPHIES = "com.example.android.brawlwiki.action.update_trophies";

    public ProfileAppWidgetService() {
        super("ProfileAppWidgetService");
    }

    public static void startActionUpdateTrophies(Context context) {
        Intent intent = new Intent(context, ProfileAppWidgetService.class);
        intent.setAction(ACTION_UPDATE_TROPHIES);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //Log.d(TAG, "onHandleIntent: ran2");
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_UPDATE_TROPHIES.equals(action)) {
                handleActionUpdateTrophies();
            }
        }
    }

    private void handleActionUpdateTrophies() {
        BrawlStarsDatabase brawlStarsDatabase = BrawlStarsDatabase.getInstance(getApplicationContext());
        ProfileDao profileDao = brawlStarsDatabase.ProfileDao();
        Player player = profileDao.getPlayerSync();

        //Log.d(TAG, "handleActionUpdateTrophies: " + player.getTrophies().toString());

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, ProfileAppWidget.class));
        ProfileAppWidget.updateProfileAppWidgets(this, appWidgetManager, player, appWidgetIds);
    }
}
