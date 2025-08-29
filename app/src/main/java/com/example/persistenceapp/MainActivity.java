package com.example.persistenceapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exitButton = findViewById(R.id.main_button_exit);
        exitButton.setOnClickListener(v -> finish());

        Intent aboutIntent = new Intent(this, AboutActivity.class);
        findViewById(R.id.main_button_about).setOnClickListener(v -> startActivity(aboutIntent));
        Intent configIntent = new Intent(this, ConfigurationActivity.class);
        findViewById(R.id.main_button_config).setOnClickListener(v -> startActivity(configIntent));

    }

}