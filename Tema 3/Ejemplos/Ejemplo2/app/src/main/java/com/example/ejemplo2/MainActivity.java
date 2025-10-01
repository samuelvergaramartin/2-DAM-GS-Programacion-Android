package com.example.ejemplo2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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

        //Creo los datos para el primer  spiner

        String valores[] = {"Dato 1", "Dato 2", "Dato 3", "Dato 4"};
        final Spinner spinner = findViewById(R.id.spinner);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));

        final TextView texto = findViewById(R.id.text1);

        String valor = spinner.getSelectedItem().toString();

        texto.setText(valor);

        //El textView no cambia porque el codigo ya se ha ejecutado
        //Pongo un listener en el spiner pra que  cuando haga una accion en el  elemento lo muestre en el TextView

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                texto.setText(parent.getSelectedItem().toString());
                //texto.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Segundo Spinner
        final Spinner spinner2 = findViewById(R.id.spinner2);
        //Creamos el adaptadorpara el segundo spinner , En este caso al hacerlo creado desde XML , el adaptador se crea de otra manera

        ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(this, R.array.valores, android.R.layout.simple_spinner_item);

        spinner2.setAdapter(adaptador2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                texto.setText(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // -------------------
        // Ahora  rescatamos el checkbox y creo un listener

        final TextView texto2 = findViewById(R.id.txt2);
        final CheckBox checkBox = findViewById(R.id.miCheck);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    texto2.setText("Seleccionado");
                    Toast.makeText(MainActivity.this, "Seleccionado", Toast.LENGTH_SHORT).show();
                }
                else {
                    texto2.setText("No seleccionado");
                    Toast.makeText(MainActivity.this, "No Seleccionado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Recuperamos el grupo del radiobutton

        final RadioGroup grupo = findViewById(R.id.grupo);

        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                final RadioButton rb = findViewById(checkedId);

                String cadena = rb.getText().toString();

                Toast.makeText(MainActivity.this, cadena, Toast.LENGTH_SHORT).show();
            }
        });

        // ---------------------
        // Recuperamos el switch y le asocio un listener

        final Switch pulsador  = findViewById(R.id.miSwitch);

        pulsador.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(MainActivity.this, "Pulsado", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "No Pulsado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // --------------------------------------------
        // Manejador del rating

        final RatingBar ratingBar = findViewById(R.id.miRating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Puntuación: " + rating, Toast.LENGTH_SHORT).show();
            }
        });

        // ----------------------------
        // Recuperamos seekbar y  creamos listener

        final SeekBar seekBar = findViewById(R.id.miSeekBar);
        final  TextView texto3 = findViewById(R.id.text3);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                texto3.setAlpha(progress/60f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Inicio de cambio de texto", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Final de cambio de texto", Toast.LENGTH_SHORT).show();
            }
        });
    }
}