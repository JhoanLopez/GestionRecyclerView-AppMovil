package com.jhoanlopez.gestiondecontactos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElement> misDatos;
    private List<ListElement> misDatosOriginal;
    private LayoutInflater inflater;
    private Context contexto;
    final ListAdapter.OnItemClickListener listener;


    public ListAdapter(List<ListElement> itemList, Context contexto, ListAdapter.OnItemClickListener listener) {
        this.inflater = LayoutInflater.from(contexto);
        this.contexto = contexto;
        this.misDatos =  itemList;
        this.listener = listener;
        this.misDatosOriginal = new ArrayList<>();
        this.misDatosOriginal.addAll(itemList);
    }

    public interface  OnItemClickListener {
        void onItemClick(ListElement item);
    }

    public void filtrado(String buscarTexto) {
        int tamaño = buscarTexto.length();
        if (tamaño == 0) {
            misDatos.clear();
            misDatos.addAll(misDatosOriginal);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<ListElement> coleccion = misDatos.stream().filter( i -> i.getNombre().toLowerCase().contains(buscarTexto)).collect(Collectors.toList());
                misDatos.clear();
                misDatos.addAll(coleccion);
            } else {
                misDatos.clear();
                for (ListElement i: misDatosOriginal) {
                    if (i.getNombre().toLowerCase().contains(buscarTexto)){
                        misDatos.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() { return misDatos.size(); }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(misDatos.get(position));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView nombre;
        TextView ciudad;
        TextView status;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iv_iconoContacto);
            nombre = (TextView) itemView.findViewById(R.id.tv_nombreContacto);
            ciudad = (TextView) itemView.findViewById(R.id.tv_paisContacto);
            status = (TextView) itemView.findViewById(R.id.tv_status);
        }

        public void bindData(final ListElement lista) {
            iconImage.setColorFilter(Color.parseColor(lista.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(lista.getNombre());
            ciudad.setText(lista.getCiudad());
            status.setText(lista.getStatus());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(lista);
                }
            });
        }
    }
}
