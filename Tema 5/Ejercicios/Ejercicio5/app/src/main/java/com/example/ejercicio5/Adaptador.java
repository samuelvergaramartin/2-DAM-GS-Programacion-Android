package com.example.ejercicio5;

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
        super(context, R.layout.contacto, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View elemento = layoutInflater.inflate(R.layout.contacto, parent, false);

        final TextView nombre = elemento.findViewById(R.id.nombre_contacto);
        final TextView telefono = elemento.findViewById(R.id.telefono_contacto);

        nombre.setText(datos.get(position).getNombre());
        telefono.setText(datos.get(position).getTelefono());

        return elemento;
    }

}
