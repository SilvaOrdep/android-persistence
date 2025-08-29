package com.example.persistenceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigurationActivity extends AppCompatActivity {

    private String name;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private EditText nameInput;
    private RadioGroup sexRadio;
    private int selectedRadioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        sharedPreferences = getSharedPreferences("BD1", Context.MODE_PRIVATE);

        name = sharedPreferences.getString("name", "Name");
        selectedRadioId = sharedPreferences.getInt("sexRadioId", 0);
        nameInput = findViewById(R.id.config_input);
        nameInput.setText(name);
        sexRadio = findViewById(R.id.config_radio_options);

        sexRadio.check(selectedRadioId);

        Button exitButton = findViewById(R.id.config_save);
        exitButton.setOnClickListener(v -> finish());
    }

    @Override
    protected void onPause() {

        editor = sharedPreferences.edit();
        name = nameInput.getText().toString();
        selectedRadioId = sexRadio.getCheckedRadioButtonId();
        editor.putString("name", name);
        editor.putInt("sexRadioId", selectedRadioId);
        editor.commit();
        super.onPause();
    }
}