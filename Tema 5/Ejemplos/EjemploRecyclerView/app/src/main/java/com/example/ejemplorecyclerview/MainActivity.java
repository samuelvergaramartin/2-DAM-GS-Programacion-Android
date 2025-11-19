package com.example.ejemplorecyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Recupero el id del RecView
        final RecyclerView recView = findViewById(R.id.recView);

        // Indicamos que el tamaño de los elementos del recview no va a cambiar
        // Se usa para mejorar el rendimiento
        recView.setHasFixedSize(true);

        // Creo los datos
        ArrayList<Opciones> datos = new ArrayList<>();
        for (int i=1; i<=32; i++){
            if (i%2 == 0){
                datos.add(new Opciones("Opción " + i,"Esta es la opción número " + i,R.drawable.star1));
            }
            else{
                datos.add(new Opciones("Opción " + i,"Esta es la opción número " + i,R.drawable.star2));
            }
        }

        // Creamos el adaptar
        AdaptadorOpciones adaptador = new AdaptadorOpciones(datos);

        // Definimos el evento onClick --> Lo hemos definido en el adaptador
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),
                        "Has hecho click en " + datos.get(recView.getChildAdapterPosition(v)).getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });

        // Asigno adaptador y layout
        recView.setAdapter(adaptador);
        recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recView.setItemAnimator(new DefaultItemAnimator());

        // Definimos los listener de los botones
        Button btnInsertar = findViewById(R.id.btnInsertar);
        Button btnBorrar = findViewById(R.id.btnBorrar);
        Button btnMover = findViewById(R.id.btnMover);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(1,new Opciones("Nueva opción","Subtítulo nueva opción",R.drawable.star1));
                adaptador.notifyItemInserted(1);

            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (datos.size()<2) return;

                datos.remove(1);
                adaptador.notifyItemRemoved(1);
            }
        });

        btnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Opciones aux = datos.get(1);
                datos.set(1,datos.get(2));
                datos.set(2,aux);

                adaptador.notifyItemMoved(1,2);
            }
        });

    }
}