package com.example.brawlwiki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.brawlwiki.databinding.ActivityTokenLoginBinding;
import com.google.firebase.analytics.FirebaseAnalytics;

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
        if (!sharedPreferences.getString(getResources().getString(R.string.my_token), "").equals("")) {
            Intent homeIntent = new Intent(this, MainActivity.class);
            startActivity(homeIntent);
        }
    }

    private void goToUrl() {
        String url = getResources().getString(R.string.brawl_stars_api_url);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void goToHomeActivity() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (!mBinding.etTokenInput.getText().toString().equals("")) {
            setTokenToSharedPreferences();
            Intent homeIntent = new Intent(this, MainActivity.class);
            startActivity(homeIntent);
        } else if (!sharedPreferences.getString(getResources().getString(R.string.my_token), "").equals("")) {
            Intent homeIntent = new Intent(this, MainActivity.class);
            startActivity(homeIntent);
        } else {
                Toast.makeText(TokenLoginActivity.this, getResources().getText(R.string.enter_token), Toast.LENGTH_LONG).show();
            }
    }

    private void setTokenToSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (sharedPreferences.getString(getResources().getString(R.string.my_token), "").equals("")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String token = mBinding.etTokenInput.getText().toString();
            editor.putString(getResources().getString(R.string.my_token), token);
            editor.apply();
        }

    }
}