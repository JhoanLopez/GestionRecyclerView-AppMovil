package com.jhoanlopez.gestiondecontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    TextView titleDescriptionTextView;
    TextView cityDescriptionTextView;
    TextView statusDescriptionTextView;
    TextView userDescriptionTextView;
    ImageView imagenView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ListElement element = (ListElement)  getIntent().getSerializableExtra("ListElement");
        titleDescriptionTextView = findViewById(R.id.titleDescriptionTextView);
        cityDescriptionTextView = findViewById(R.id.cityDescriptionTextView);
        statusDescriptionTextView = findViewById(R.id.statusDescriptionTextView);
        userDescriptionTextView = findViewById(R.id.tv_descripcion);
        imagenView = findViewById(R.id.imageView);

        titleDescriptionTextView.setText(element.getNombre());
        cityDescriptionTextView.setText(element.getCiudad());
        cityDescriptionTextView.setTextColor(Color.GRAY);
        imagenView.setColorFilter(Color.parseColor(element.getColor()));
        statusDescriptionTextView.setText(element.getStatus());
        statusDescriptionTextView.setTextColor(Color.GRAY);
        userDescriptionTextView.setText(element.getDescripcion());
        userDescriptionTextView.setTextColor(Color.GRAY);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_buscar:
                Intent intentBuscar = new Intent(this, BuscarStreamer.class);
                startActivity(intentBuscar);
                break;
            case R.id.mi_salir:
                Intent intentSalir = new Intent(this, Categories.class);
                startActivity(intentSalir);
                break;
            case R.id.mi_privacidad:
                Intent intentPrivacidad = new Intent(this, PoliticaDePrivacidad.class);
                startActivity(intentPrivacidad);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}