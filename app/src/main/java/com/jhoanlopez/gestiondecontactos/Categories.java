package com.jhoanlopez.gestiondecontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Categories extends AppCompatActivity {
    Button playStation;
    Button xbox;
    Button pc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Intent intent = new Intent(this, MainActivity.class);

        playStation = findViewById(R.id.but_playStation);
        xbox = findViewById(R.id.but_xbox);
        pc = findViewById(R.id.but_pc);



        playStation.setOnClickListener(v -> {
                intent.putExtra("1", "Play Station Gamers");
                startActivity(intent);
        });

        xbox.setOnClickListener(v -> {
                intent.putExtra("1", "XBOX Gamers");
                startActivity(intent);
        });

        pc.setOnClickListener(v -> {
                intent.putExtra("1", "PC Gamers");
                startActivity(intent);
        });
    }
}