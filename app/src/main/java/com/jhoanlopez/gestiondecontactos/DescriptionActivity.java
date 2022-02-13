package com.jhoanlopez.gestiondecontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DescriptionActivity extends AppCompatActivity {

    TextView titleDescriptionTextView;
    TextView cityDescriptionTextView;
    TextView statusDescriptionTextView;
    ImageView imagenView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ListElement element = (ListElement)  getIntent().getSerializableExtra("ListElement");
        titleDescriptionTextView = findViewById(R.id.titleDescriptionTextView);
        cityDescriptionTextView = findViewById(R.id.cityDescriptionTextView);
        statusDescriptionTextView = findViewById(R.id.statusDescriptionTextView);
        imagenView = findViewById(R.id.imageView);

        titleDescriptionTextView.setText(element.getNombre());

        cityDescriptionTextView.setText(element.getCiudad());
        cityDescriptionTextView.setTextColor(Color.GRAY);

        imagenView.setColorFilter(Color.parseColor(element.getColor()));

        statusDescriptionTextView.setText(element.getStatus());
        statusDescriptionTextView.setTextColor(Color.GRAY);
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
            case R.id.mi_item1:
                Toast.makeText(this, "Opción A", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mi_item2:
                Toast.makeText(this, "Opción B", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mi_item3:
                Toast.makeText(this, "Opción C", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}