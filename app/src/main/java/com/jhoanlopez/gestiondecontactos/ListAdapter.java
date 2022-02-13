package com.jhoanlopez.gestiondecontactos;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElement> misDatos;
    private LayoutInflater inflater;
    private Context contexto;
    final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ListElement item);
    }

    public ListAdapter(List<ListElement> itemList, Context contexto, OnItemClickListener listener) {
        this.inflater = LayoutInflater.from(contexto);
        this.contexto = contexto;
        this.misDatos =  itemList;
        this.listener = listener;
    }

    @Override
    public int getItemCount() { return misDatos.size(); }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_element, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binData(misDatos.get(position));
    }

    public void setItems(List<ListElement> items) { misDatos = items; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView nombre;
        TextView ciudad;
        TextView status;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iv_iconoContacto);
            nombre = itemView.findViewById(R.id.tv_nombreContacto);
            ciudad = itemView.findViewById(R.id.tv_paisContacto);
            status = itemView.findViewById(R.id.tv_status);
        }

        public void binData(final ListElement item) {
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(item.nombre);
            ciudad.setText(item.ciudad);
            status.setText(item.status);
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}
