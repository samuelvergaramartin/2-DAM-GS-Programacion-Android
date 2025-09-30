package com.example.eemplo1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
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

        ImageView imagen2 = findViewById(R.id.img1);

        imagen2.setImageResource(R.drawable.android);

        // Creamos los datos para el autocompletextextview , el adaptador y  se lo  asignamos

        String opciones[] = {"Opcion 1",  "Opcion 2", "Opcion 3", "Opcion 4"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, opciones);
        final AutoCompleteTextView textoLeido = findViewById(R.id.actext);

        textoLeido.setAdapter(adaptador);

        final MultiAutoCompleteTextView mac = findViewById(R.id.mac);

        mac.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mac.setAdapter(adaptador);
    }
}