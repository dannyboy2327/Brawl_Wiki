package com.example.brawlwiki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.brawlwiki.databinding.ActivityTokenLoginBinding;
import com.example.brawlwiki.ui.home.HomeFragment;

public class TokenLoginActivity extends AppCompatActivity {

    private ActivityTokenLoginBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkTokenState();

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_token_login);

        mBinding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHomeActivity();
            }
        });

        mBinding.tvTokenLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl();
            }
        });
    }

    private void checkTokenState() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (!sharedPreferences.getString("MyToken", "").equals("")) {
            goToHomeActivity();
        }
    }

    private void goToUrl() {
        String url = "https://developer.brawlstars.com/#/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void goToHomeActivity() {
        setTokenToSharedPreferences();
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
    }

    private void setTokenToSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (sharedPreferences.getString("MyToken", "").equals("")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String token = mBinding.etTokenInput.getText().toString();
            editor.putString("MyToken", token);
            editor.apply();
        }

    }
}