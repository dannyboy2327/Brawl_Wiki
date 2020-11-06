package com.brawl.brawlwiki;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isTablet = getResources().getBoolean(R.bool.isTablet);
        int orientation = getResources().getConfiguration().orientation;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        if (isTablet && orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_home, R.id.nav_players, R.id.nav_brawlers, R.id.nav_clubs, R.id.nav_settings)
                    .setOpenableLayout(drawer)
                    .build();
            Menu navMenu = navigationView.getMenu();
            navMenu.findItem(R.id.nav_home).setVisible(false);
        } else {
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_home, R.id.nav_players, R.id.nav_brawlers, R.id.nav_clubs, R.id.nav_settings)
                    .setOpenableLayout(drawer)
                    .build();
        }


        if (isTablet && orientation == Configuration.ORIENTATION_LANDSCAPE) {
            NavController navSecondaryController = Navigation.findNavController(this, R.id.nav_secondary_host_fragment);
            NavigationUI.setupActionBarWithNavController(this, navSecondaryController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navSecondaryController);

        } else {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
        }

        displayBanner();
    }

    private void displayBanner() {
        MobileAds.initialize(MainActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView = findViewById(R.id.adView_main_ad);
        adView.loadAd(adRequest);
    }


    @Override
    public boolean onSupportNavigateUp() {

        boolean isTablet = getResources().getBoolean(R.bool.isTablet);
        int orientation = getResources().getConfiguration().orientation;

        NavController navController;
        if (isTablet && orientation == Configuration.ORIENTATION_LANDSCAPE) {
            navController = Navigation.findNavController(this, R.id.nav_secondary_host_fragment);
        } else {
            navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        }
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}