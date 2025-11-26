package com.example.ejemplopreferenciascompartidas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        final Button guardar = findViewById(R.id.btnGuardar);
        final Button cargar = findViewById(R.id.btnCargar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtengo la referencia de la coleccion de la referencia donde voy a guardar las preferencias
                SharedPreferences preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                //Guardar los valores
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nombre", "Rocio");
                editor.putString("email", "rocio@gmail.com");

                // Guardar los cambios con un commit
                editor.commit();
            }
        });

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtengo la referencia de la coleccion de la referencia donde voy a guardar las preferencias
                SharedPreferences preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                String nombre = preferences.getString("nombre", "");
                String correo = preferences.getString("email", "");

                Log.i("Preferencias", "Nombre: " + nombre + "\nCorreo: " + correo);
            }
        });
    }
}