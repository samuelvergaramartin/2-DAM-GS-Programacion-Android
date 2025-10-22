package com.example.examentema3samuelvergaramartin;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

                Toast.makeText(Activity3.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}