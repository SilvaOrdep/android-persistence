package com.example.persistenceapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button exitButton = findViewById(R.id.about_exit_button);
        exitButton.setOnClickListener(v -> finish());

    }
}