package com.example.examentema3samuelvergaramartin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
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
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final AutoCompleteTextView userInput = findViewById(R.id.input1_activity_main);
        final EditText passwordInput = findViewById(R.id.input2_activity_main);
        final Button button = findViewById(R.id.button_activity_main);
        final ProgressBar progressBar = findViewById(R.id.progress_bar_activity_main);
        final Handler handler = new Handler();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.user_values, android.R.layout.simple_dropdown_item_1line);
        userInput.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userInput.getText().toString().isEmpty() || passwordInput.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Los campos usuario y clave no pueden estar vacíos.", Toast.LENGTH_SHORT).show();
                }
                else {
                    userInput.setVisibility(View.GONE);
                    passwordInput.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            Intent actividad2 = new Intent(MainActivity.this, Activity2.class);
                            startActivity(actividad2);
                        }
                    },3000);
                }
            }
        });
    }
}