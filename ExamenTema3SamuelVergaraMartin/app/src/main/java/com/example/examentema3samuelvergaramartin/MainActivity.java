package com.example.examentema3samuelvergaramartin;

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
        actividad1();
        //actividad2();
        //actividad3();
    }

    private void actividad1() {
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
                        }
                    },3000);
                }
            }
        });
    }

    private void actividad2() {
        setContentView(R.layout.activity2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final TextView text1 = findViewById(R.id.text1_activity2);
        final TextView text2 = findViewById(R.id.text2_activity2);
        final TextView text3 = findViewById(R.id.text3_activity2);
        final String toastMessage = "Futuro Intent";

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void actividad3() {
        setContentView(R.layout.activity3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final LinearLayout layout = findViewById(R.id.activity3);
        final SeekBar seekBarRed = findViewById(R.id.seekbar_r);
        final SeekBar seekBarGreen = findViewById(R.id.seekbar_g);
        final SeekBar seekBarBlue = findViewById(R.id.seekbar_b);
        final Button button1 = findViewById(R.id.button1_activity3);
        final Button button2 = findViewById(R.id.button2_activity3);
        final CheckBox checkBox1 = findViewById(R.id.checkbox1_activity3);
        final CheckBox checkBox2 = findViewById(R.id.checkbox2_activity3);
        final CheckBox checkBox3 = findViewById(R.id.checkbox3_activity3);
        final CheckBox checkBox4 = findViewById(R.id.checkbox4_activity3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.rgb(seekBarRed.getProgress(), seekBarGreen.getProgress(), seekBarBlue.getProgress()));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastMessage = "  ";
                if(checkBox1.isChecked()) toastMessage+= checkBox1.getText() + " ";
                if(checkBox2.isChecked()) toastMessage+= checkBox2.getText() + " ";
                if(checkBox3.isChecked()) toastMessage+= checkBox3.getText() + " ";
                if(checkBox4.isChecked()) toastMessage+= checkBox4.getText() + " ";

                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}