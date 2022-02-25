package com.jhoanlopez.gestiondecontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, androidx.appcompat.widget.SearchView.OnQueryTextListener {

    public static List<ListElement> elementos;
    TextView categoriaElegida;
    androidx.appcompat.widget.SearchView sv_buscar;
    ListAdapter listAdapter;
    String activo;
    String ausente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent recibir = getIntent();
        String categoria = recibir.getStringExtra("1");

        categoriaElegida = findViewById(R.id.tv_categoriaElegida);
        sv_buscar = findViewById(R.id.sv_buscar);

        sv_buscar.setOnQueryTextListener(this);
        categoriaElegida.setText(categoria);
        activo = getResources().getString(R.string.activo);
        ausente = getResources().getString(R.string.ausente);

        if (categoria.equalsIgnoreCase("Play Station Gamers")) {
            addPlayStationStreamers();
        } else if (categoria.equalsIgnoreCase("XBOX Gamers")) {
            addXboxStreamers();
        } else if (categoria.equalsIgnoreCase("PC Gamers")) {
            addPcStreamers();
        }
    }


    public void addPlayStationStreamers() {
        elementos = new ArrayList<>();

        elementos.add(new ListElement("#29B6F6", "Pedro", "Mexico", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#CB4335", "Juan", "España", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#6C3483", "Arnold", "USA", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#E64A19", "Felipe", "Brasil", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#AD1457", "Mateo", "Argentina", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#7CB342", "Franccesco", "Italia", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#FFEB3B", "Camilo", "Colombia", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#0D47A1", "Tyrone", "Venezuela", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#37474F", "Drake", "Canadá", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));

        listAdapter = new ListAdapter(elementos, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescripcion(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    };


    public void addXboxStreamers() {
        elementos = new ArrayList<>();

        elementos.add(new ListElement("#512DA8", "Diego Franco", "Mexico", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros.  In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis."));
        elementos.add(new ListElement("#CB4335", "Markos ", "España", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis."));
        elementos.add(new ListElement("#6C3483", "Arnold", "USA", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis."));
        elementos.add(new ListElement("#E64A19", "Felipe", "Brasil", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis."));
        elementos.add(new ListElement("#AD1457", "Mateo", "Argentina", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis."));
        elementos.add(new ListElement("#7CB342", "Franccesco", "Italia", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis."));
        elementos.add(new ListElement("#FFEB3B", "Camilo", "Colombia", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis."));
        elementos.add(new ListElement("#0D47A1", "Tyrone", "Venezuela", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis."));
        elementos.add(new ListElement("#37474F", "Drake", "Canadá", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis."));

        listAdapter = new ListAdapter(elementos, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescripcion(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    };


    public void addPcStreamers() {
        elementos = new ArrayList<>();

        elementos.add(new ListElement("#512DA8", "El Rubius", "España", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#CB4335", "Juan", "España", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#512DA8", "Ibai Llanos", "España", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#E64A19", "Felipe", "Brasil", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#AD1457", "Mateo", "Argentina", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#7CB342", "Franccesco", "Italia", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#FFEB3B", "Camilo", "Colombia", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#512DA8", "Kun Agüero", "Argentina", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));
        elementos.add(new ListElement("#512DA8", "Auron Play", "España", activo, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra, dui porttitor ultricies efficitur, neque turpis elementum lectus, et faucibus justo ipsum ac eros. Donec feugiat ipsum orci, at dictum orci euismod a. In faucibus ac augue vel semper. Vestibulum lobortis finibus venenatis. Nunc sed purus in felis dictum commodo."));

        listAdapter = new ListAdapter(elementos, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescripcion(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    };


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


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filtrado(newText);
        return false;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}