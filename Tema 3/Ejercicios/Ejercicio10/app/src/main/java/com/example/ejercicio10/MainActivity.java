package com.example.ejercicio10;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

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

        final EditText name = findViewById(R.id.name_input);
        final EditText password = findViewById(R.id.password_input);
        final Button resetButton = findViewById(R.id.reset_button);
        final String defaultNameText = name.getText().toString();
        final String defaultPasswordText = password.getText().toString();

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if(password.getInputType() != (EditorInfo.TYPE_TEXT_VARIATION_PASSWORD + 1) && !password.getText().toString().equals(defaultPasswordText)) {
                    password.setInputType(EditorInfo.TYPE_TEXT_VARIATION_PASSWORD + 1);
                    password.setText(password.getText().toString().replace(defaultPasswordText, ""));
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(defaultNameText);
                password.setText(defaultPasswordText);
                password.setInputType(EditorInfo.TYPE_CLASS_TEXT);
            }
        });
    }
}