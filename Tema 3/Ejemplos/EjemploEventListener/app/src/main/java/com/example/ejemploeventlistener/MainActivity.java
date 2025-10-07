package com.example.ejemploeventlistener;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

        //Recupero los elementos del layout
        final TextView etiqueta = findViewById(R.id.lbl1);
        final  TextView etiqueta2 = findViewById(R.id.lbl2);
        final EditText texto = findViewById(R.id.et);

        //Defino event listener TextChangedListener

        texto.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            //Metodo que se lanza antes de cambiar el texto
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                etiqueta.setText("Texto antes de cambiar: " + s.toString());

                //Este metodo es llamado para  notificar que dentro de sm count,
                // caracteres a partir  e start va a ser eemplezazado por nuevo textoç
                //cuya longitud viene dada pr after

                etiqueta2.setText("Texto antes de cambiar: " + s + " start: " + start + " count: " + count + " after: " + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
    }

    public void onClick(View view){
        final TextView etiqueta = findViewById(R.id.lbl3);
        int id = view.getId();

        if(id == R.id.btnAceptar) {
            etiqueta.setText("Aceptar");
        }
        else if(id == R.id.btnCancelar) {
            etiqueta.setText("Cancelar");
        }
    }
}