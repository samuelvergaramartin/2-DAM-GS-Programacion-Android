package com.example.ejercicio12;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

        final GridLayout aficciones = findViewById(R.id.aficciones);
        final RadioGroup radioGenero = findViewById(R.id.radioGenero);
        final RadioGroup radioDeporte = findViewById(R.id.radioDeporte);
        final Button resetButton = findViewById(R.id.reset_button);
        final Button acceptButton = findViewById(R.id.accept_button);
        final TextView textview1 = findViewById(R.id.textview1);
        final TextView textview2 = findViewById(R.id.textview2);
        final TextView textview3 = findViewById(R.id.textview3);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < aficciones.getChildCount(); i++) {
                    if(aficciones.getChildAt(i) instanceof CheckBox) ((CheckBox) aficciones.getChildAt(i)).setChecked(false);
                }
                radioGenero.clearCheck();
                radioDeporte.clearCheck();
                textview1.setVisibility(View.INVISIBLE);
                textview2.setVisibility(View.INVISIBLE);
                textview3.setVisibility(View.INVISIBLE);
            }
        });

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String afficionesHeader = "Tus aficciones son:\n";
                final int genRadioButtonID = radioGenero.getCheckedRadioButtonId();
                final int depRadioButtonID = radioDeporte.getCheckedRadioButtonId();
                String textoAficciones = "", textoGenero = "", textoDeporte = "";

                for(int i = 0; i < aficciones.getChildCount(); i++) {
                    if(aficciones.getChildAt(i) instanceof CheckBox && ((CheckBox) aficciones.getChildAt(i)).isChecked()) {
                        textoAficciones+= ((CheckBox) aficciones.getChildAt(i)).getText().toString() + "\n";
                    }
                }

                if(!textoAficciones.isEmpty()) {
                    textoAficciones = afficionesHeader + textoAficciones;
                    textview1.setText(textoAficciones);
                    textview1.setVisibility(View.VISIBLE);
                }


                if(genRadioButtonID != -1) {
                    RadioButton radioButton = findViewById(genRadioButtonID);
                    textoGenero = radioButton.getText().toString();
                    textview2.setText("Su género seleccionado es: " + textoGenero);
                    textview2.setVisibility(View.VISIBLE);
                }

                if(depRadioButtonID != -1) {
                    RadioButton radioButton = findViewById(depRadioButtonID);
                    textoDeporte = radioButton.getText().toString();
                    textview3.setText("Su deporte seleccionado es: " + textoDeporte);
                    textview3.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}