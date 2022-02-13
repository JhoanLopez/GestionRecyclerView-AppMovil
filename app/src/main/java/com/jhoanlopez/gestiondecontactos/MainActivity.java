package com.jhoanlopez.gestiondecontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElement> elementos;
    TextView categoriaElegida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoriaElegida = findViewById(R.id.tv_categoriaElegida);

        //Así se extraen los datos después de hacer un putExtra en otra pantalla
        Intent recibir = getIntent();
        String datos = recibir.getStringExtra("1");

        categoriaElegida.setText(datos);
        init();
    }

    public void init() {
        elementos = new ArrayList<>();
        elementos.add(new ListElement("#29B6F6", "Pedro", "Mexico", "Activo"));
        elementos.add(new ListElement("#CB4335", "Juan", "España", "Activo"));
        elementos.add(new ListElement("#6C3483", "Arnold", "USA", "Activo"));
        elementos.add(new ListElement("#E64A19", "Felipe", "Brasil", "Activo"));
        elementos.add(new ListElement("#AD1457", "Mateo", "Argentina", "Activo"));
        elementos.add(new ListElement("#7CB342", "Franccesco", "Italia", "Activo"));
        elementos.add(new ListElement("#FFEB3B", "Camilo", "Colombia", "Activo"));
        elementos.add(new ListElement("#0D47A1", "Tyrone", "Venezuela", "Activo"));
        elementos.add(new ListElement("#37474F", "Drake", "Canadá", "Activo"));


        ListAdapter listAdapter = new ListAdapter(elementos, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescripcion(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }


    public void moveToDescripcion(ListElement item) {
        Intent intent = new Intent(this, DescriptionActivity.class );
        intent.putExtra("ListElement", item);
        startActivity(intent);
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