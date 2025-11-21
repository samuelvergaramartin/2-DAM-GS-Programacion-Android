package com.example.ejercicio8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        final ArrayList<Datos> datos = new ArrayList<>();
        datos.add(new Datos(R.drawable.tv, "Televisión"));
        datos.add(new Datos(R.drawable.smartphone, "Teléfono Móvil"));
        datos.add(new Datos(R.drawable.tablet, "Tablet"));
        datos.add(new Datos(R.drawable.ordenador_fijo, "Ordenador Fijo"));
        datos.add(new Datos(R.drawable.ordenador_portatil, "Ordenador Portátil"));
        datos.add(new Datos(R.drawable.reloj, "Reloj"));

        final Adaptador adaptador = new Adaptador(this, datos);
        final ListView listado = findViewById(R.id.listado);
        final View cabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        final Button boton = cabecera.findViewById(R.id.boton);
        final ArrayList<String> dispositivosSeleccionados = new ArrayList<>();

        listado.addHeaderView(cabecera);
        listado.setAdapter(adaptador);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int contador = 0;
                for(Datos dato : datos) {
                    if(dato.isChecked()) contador++;
                }

                if(contador == 0) Toast.makeText(MainActivity.this, "No hay elementos  seleccionados", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, "Hay " + contador + " elementos seleccionados", Toast.LENGTH_SHORT).show();
            }
        });
    }
}