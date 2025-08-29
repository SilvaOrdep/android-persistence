package com.example.persistenceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigurationActivity extends AppCompatActivity {

    private int testCounter;
    private String name;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        sharedPreferences = getSharedPreferences("BD1", Context.MODE_PRIVATE);

        name = sharedPreferences.getString("name", "Name");
        testCounter = sharedPreferences.getInt("testCounter", 0);
        testCounter++;
        Toast.makeText(this, "Fodase "+testCounter+" vezes", Toast.LENGTH_SHORT).show();

        input = findViewById(R.id.config_input);
        input.setText(name);

        Button exitButton = findViewById(R.id.config_save);
        exitButton.setOnClickListener(v -> finish());
    }

    @Override
    protected void onPause() {

        editor = sharedPreferences.edit();
        name = input.getText().toString();
        editor.putInt("testCounter", testCounter);
        editor.putString("name", name);

        editor.commit();
        super.onPause();
    }
}