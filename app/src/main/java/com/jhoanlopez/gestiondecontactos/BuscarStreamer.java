package com.jhoanlopez.gestiondecontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class BuscarStreamer extends AppCompatActivity {

    Button buscar;
    EditText nombre;
    EditText ciudad;
    Spinner spinner;
    List<ListElement> elementos;
    String activo;
    String ausente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_streamer);

        buscar = findViewById(R.id.but_buscar);
        nombre = findViewById(R.id.editTextTextPersonName);
        ciudad = findViewById(R.id.editTextTextPersonName2);
        spinner = findViewById(R.id.spinner);

        activo = getResources().getString(R.string.activo);
        ausente = getResources().getString(R.string.ausente);

        MainActivity main = new MainActivity();
        elementos = main.elementos;

        ArrayList<Estados> estado = new ArrayList<>();
        estado.add(new Estados(activo));
        estado.add(new Estados(ausente));

        ArrayAdapter<Estados> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, estado);
        spinner.setAdapter(adapter);

        buscar.setOnClickListener(v -> {

            try {
                if (TextUtils.isEmpty(nombre.getText()) == false && (TextUtils.isEmpty(ciudad.getText())) == false) {

                    ListElement list = null;
                    for(int i = 0; i < elementos.size(); i++) {
                        list = main.elementos.get(i);
                        String nombre = list.getNombre();
                        String ciudad = list.getCiudad();
                        String estados = list.getStatus();

                        if(nombre.equalsIgnoreCase(this.nombre.getText().toString()) &&
                            ciudad.equalsIgnoreCase(this.ciudad.getText().toString()) &&
                            estados.equalsIgnoreCase(this.spinner.getSelectedItem().toString())) {
                            moveToDescripcion(list);
                        }
                    }
                }
            } catch (Exception ex ) {
                System.out.println("ERROR:");
                System.out.println(ex);
            }
        });
    };

    public void moveToDescripcion(ListElement item) {
        Intent intent = new Intent(this, DescriptionActivity.class );
        intent.putExtra("ListElement", item);
        startActivity(intent);
    };
}