package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();
        if(config.smallestScreenWidthDp < 600) {
            setContentView(R.layout.activity_main_phone);
        }
        else
        {
            setContentView(R.layout.activity_main_tablet);
        }
    }
}