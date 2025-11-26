package com.example.ejercicio1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorOpciones {

}

public class OpcionViewHolder extends RecyclerView.ViewHolder {
    private ImageView imagen;
    private TextView titulo;
    private TextView texto;

    public OpcionViewHolder(@NonNull View itemView) {
        super(itemView);

        this.titulo = itemView.findViewById(R.id.titulo);
        this.texto = itemView.findViewById(R.id.texto);
        this.imagen = itemView.findViewById(R.id.imagen);
    }

    
}
