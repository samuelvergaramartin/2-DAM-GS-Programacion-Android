package com.example.eemplo1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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
        //Buscamos los ID de las etiquetas
        final TextView etq1 = findViewById(R.id.lbl1);
        final TextView etq7 = findViewById(R.id.lbl7);

        //Obtengo el texto de la etiqueta 1
        String texto = etq1.getText().toString();
        etq7.setText("Texto copiado de etiqueta 1: " + texto);

        //----------------------------------------------
        //rescato ids y creo listeners

        final TextView etqBtn = findViewById(R.id.lbnbtn);
        final Button miBoton = findViewById(R.id.btn1);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etqBtn.setText("Pulsado botón simple");
            }
        });

        final ToggleButton miToggleBtn = findViewById(R.id.togglebtn);
        miToggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    etqBtn.setText("Toggle Button activado");
                }
                else etqBtn.setText("Toggle Button desctivado");
            }
        });

        final ImageButton btnImagen = findViewById(R.id.imgbtn);
        final ImageButton btnImagen2 = findViewById(R.id.imgbtn2);

        btnImagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnImagen.setImageResource(R.drawable.feliz);
            }
        });
    }
}