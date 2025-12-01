package com.example.ejercicio1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorOpciones extends RecyclerView.Adapter<OpcionViewHolder> implements View.OnClickListener {
    private ArrayList<Opciones> opciones;
    private View.OnClickListener listener;

    public AdaptadorOpciones(ArrayList<Opciones> opciones) {
        this.opciones = opciones;
    }


    @Override
    public void onClick(View v) {
        if(listener != null) {
            listener.onClick(v);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public OpcionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento, parent, false);
        itemView.setOnClickListener(this);

        OpcionViewHolder ovh = new OpcionViewHolder(itemView);

        return ovh;
    }

    @Override
    public void onBindViewHolder(@NonNull OpcionViewHolder holder, int position) {
        Opciones item = opciones.get(position);
        holder.bindOpcion(item);
    }

    @Override
    public int getItemCount() {
        return opciones.size();
    }
}

class OpcionViewHolder extends RecyclerView.ViewHolder {
    private ImageView imagen;
    private TextView titulo;
    private TextView texto;

    public OpcionViewHolder(@NonNull View itemView) {
        super(itemView);

        titulo = itemView.findViewById(R.id.titulo);
        texto = itemView.findViewById(R.id.texto);
        imagen = itemView.findViewById(R.id.imagen);
    }

<<<<<<< HEAD

=======
    public void bindOpcion(Opciones o) {
        texto.setText(o.getTexto());
        titulo.setText(o.getTitulo());
        imagen.setImageResource(o.getImagen());
    }
>>>>>>> 23698821c565df046c9a289c1ce9809ffbb950c8
}
