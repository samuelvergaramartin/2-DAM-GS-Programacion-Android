package com.example.ejercicio6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<Datos> {
    private ArrayList<Datos> datos;

    public Adaptador(@NonNull Context context, ArrayList<Datos> datos) {
        super(context, R.layout.contenido, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View elemento = layoutInflater.inflate(R.layout.contenido, parent, false);

        final TextView titulo = elemento.findViewById(R.id.titulo);
        final TextView texto = elemento.findViewById(R.id.texto);

        titulo.setText(datos.get(position).getTitulo());
        texto.setText(datos.get(position).getTexto());

        return elemento;
    }
}
