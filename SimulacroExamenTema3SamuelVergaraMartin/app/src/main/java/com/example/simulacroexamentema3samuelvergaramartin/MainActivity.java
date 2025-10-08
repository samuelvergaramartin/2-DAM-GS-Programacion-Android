package com.example.simulacroexamentema3samuelvergaramartin;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //actividad1();
        //actividad2();
        actividad3();
    }

    private void actividad1() {
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText userInput = findViewById(R.id.activity_main_user_input);
        EditText passwordInput = findViewById(R.id.activity_main_password_input);
        Button activityMainButton = findViewById(R.id.activity_main_button);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                userInput.setVisibility(View.VISIBLE);
                passwordInput.setVisibility(View.VISIBLE);
                activityMainButton.setVisibility(View.VISIBLE);

                activityMainButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(userInput.getText().toString().isEmpty() || passwordInput.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity.this, "Introoduce usuario y clave", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Hola Samuel. Accediendo a la app", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        },3000);
    }

    private void actividad2() {
        setContentView(R.layout.activity2);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final Button button1 = findViewById(R.id.activity2_button1);
        final Button button2 = findViewById(R.id.activity2_button2);
        final Button button3 = findViewById(R.id.activity2_button3);
        final Button button4 = findViewById(R.id.activity2_button4);
        final int defaultColor = Color.rgb(247,193,234), clickedColor = Color.rgb(243,230,248);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(clickedColor);
                button2.setBackgroundColor(defaultColor);
                button3.setBackgroundColor(defaultColor);
                button4.setBackgroundColor(defaultColor);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(defaultColor);
                button2.setBackgroundColor(clickedColor);
                button3.setBackgroundColor(defaultColor);
                button4.setBackgroundColor(defaultColor);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(defaultColor);
                button2.setBackgroundColor(defaultColor);
                button3.setBackgroundColor(clickedColor);
                button4.setBackgroundColor(defaultColor);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void actividad3() {
        setContentView(R.layout.activity3);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final Spinner spinner = findViewById(R.id.miSpinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_values, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


}