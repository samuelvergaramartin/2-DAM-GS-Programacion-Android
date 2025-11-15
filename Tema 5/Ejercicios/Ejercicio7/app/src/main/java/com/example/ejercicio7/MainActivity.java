package com.example.ejercicio7;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;

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

        ArrayList<Datos> datos = new ArrayList<>();
        datos.add(new Datos(R.drawable.buho, "Buho"));
        datos.add(new Datos(R.drawable.cachorros, "Cachorros"));
        datos.add(new Datos(R.drawable.cerdo, "Cerdo"));
        datos.add(new Datos(R.drawable.jirafas, "Jirafas"));
        datos.add(new Datos(R.drawable.lobo, "Lobo"));
        datos.add(new Datos(R.drawable.potro, "Potro"));
        datos.add(new Datos(R.drawable.tigre, "Tigre"));
        datos.add(new Datos(R.drawable.tortuga, "Tortuga"));
        datos.add(new Datos(R.drawable.tucan, "Tucán"));

        GridLayout contenedor = findViewById(R.id.container);
        for(Datos dato : datos) {
            ListView listado = new ListView(this);

        }
    }
}