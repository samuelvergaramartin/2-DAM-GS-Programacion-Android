package com.example.ejercicio7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<Datos> datos;
    private Context contexto;

    public Adaptador(Context contexto,  ArrayList<Datos> datos) {
        super();
        this.contexto = contexto;
        this.datos = datos;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(contexto);
        View elemento = layoutInflater.inflate(R.layout.elemento, parent, false);

        final ImageView imagen = elemento.findViewById(R.id.imagen);
        imagen.setImageResource(datos.get(position).getImagen());

        final TextView texto = elemento.findViewById(R.id.texto);
        texto.setText(datos.get(position).getTexto());

        return elemento;
    }
}
