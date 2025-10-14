package com.example.ejemplo1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Definimos el evento callback onCreate de la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.secondary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Mostramos el toast con un mensaje
        Toast.makeText(this, "Se ejecuta el método onCreate", Toast.LENGTH_SHORT).show();
    }

    //Definimos el metodo onStart
    @Override
    protected void onStart() {
        super.onStart();

        //Aqui deberiamos leer los datos de la  ultima sesion para continuar la actividad donde la dejo el usuario
        Toast.makeText(this, "Se ejecuta el método onStart", Toast.LENGTH_SHORT).show();
    }

    //Definimos el metodo onResume de la actividad
    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Se ejecuta el método onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Aqui deberiamos guardar la informacion para la siguiente sesion
        Toast.makeText(this, "Se ejecuta el metod onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Se ejecuta el metodo onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        Toast.makeText(this, "Se ejecuta el método onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "Se ejecuta el método onRestart", Toast.LENGTH_SHORT).show();
    }
}