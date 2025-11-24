package com.example.ejercicio2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final TextView texto = findViewById(R.id.texto);
        int id = item.getItemId();
        String opcion = (String) item.getTitle();

        if(
                id == R.id.lunes || id == R.id.martes || id == R.id.miercoles ||
                id == R.id.jueves || id == R.id.viernes || id == R.id.sabado ||
                id == R.id.domingo
        ) texto.setText("Pulsado " + opcion);
        else if(
                id == R.id.enero || id == R.id.febrero || id == R.id.marzo ||
                id == R.id.abril || id == R.id.mayo || id == R.id.junio ||
                id == R.id.julio || id == R.id.agosto || id == R.id.septiembre ||
                id == R.id.octubre || id == R.id.noviembre || id == R.id.diciembre
        ) texto.setText("Pulsado el mes de " + opcion);

        return super.onOptionsItemSelected(item);
    }
}