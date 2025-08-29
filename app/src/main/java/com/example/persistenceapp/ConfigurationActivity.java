package com.example.persistenceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigurationActivity extends AppCompatActivity {

    private int testCounter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        sharedPreferences = getSharedPreferences("BD1", Context.MODE_PRIVATE);

        testCounter = sharedPreferences.getInt("testCounter", 0);
        testCounter++;
        Toast.makeText(this, "Fodase "+testCounter+" vezes", Toast.LENGTH_SHORT).show();

        Button exitButton = findViewById(R.id.config_save);
        exitButton.setOnClickListener(v -> finish());
    }

    @Override
    protected void onPause() {

        editor = sharedPreferences.edit();

        editor.putInt("testCounter", testCounter);
        editor.commit();
        super.onPause();
    }
}