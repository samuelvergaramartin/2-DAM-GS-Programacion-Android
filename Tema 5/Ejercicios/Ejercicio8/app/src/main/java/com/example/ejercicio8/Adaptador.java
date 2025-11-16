package com.example.ejercicio8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<Datos> {
    private ArrayList<Datos> datos;

    public Adaptador(Context contexto, ArrayList<Datos> datos) {
        super(contexto, R.layout.elemento, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View elemento = layoutInflater.inflate(R.layout.elemento, parent, false);

        final ImageView imagen = elemento.findViewById(R.id.imagen);
        imagen.setImageResource(datos.get(position).getImagen());

        final TextView texto = elemento.findViewById(R.id.texto);
        texto.setText(datos.get(position).getTexto());

        return elemento;
    }
}
