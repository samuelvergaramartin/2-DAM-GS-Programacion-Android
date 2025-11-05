package com.example.ejemploadaptadorimagenes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<Datos> datos;
    private Context contexto;

    public Adaptador(ArrayList<Datos> datos, Context contexto) {
        super();
        this.datos = datos;
        this.contexto = contexto;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);

        final ImageView icono = elemento.findViewById(R.id.imagen);
        icono.setImageResource(datos.get(position).getIcono());

        final TextView texto = elemento.findViewById(R.id.texto);
        texto.setText(datos.get(position).getTexto());

        return elemento;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
