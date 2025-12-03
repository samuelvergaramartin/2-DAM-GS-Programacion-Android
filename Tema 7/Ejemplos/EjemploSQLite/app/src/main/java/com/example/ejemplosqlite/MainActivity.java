package com.example.ejemplosqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        // Obtengo los elementos del layout
        final TextView lbConsulta = findViewById(R.id.lblConsulta);
        final EditText codigo = findViewById(R.id.etCodigo);
        final EditText nombre = findViewById(R.id.etNombre);
        final Button btnInsertar = findViewById(R.id.btnInsertar);
        final Button btnBorrar = findViewById(R.id.btnBorrar);
        final Button btnActualizar = findViewById(R.id.btnActualizar);
        final Button btnConsultar = findViewById(R.id.btnConsultar);

        // Abrimos la base de datos de DBUsuarios en modo de escritura
        UsuariosBBDD usuariosBBDD = new UsuariosBBDD(this, "DBUsuarios", null, 1); //Establece la conexion
        SQLiteDatabase db = usuariosBBDD.getWritableDatabase();

        //Compruebo que se ha abierto la base de datos
        if(db != null) {
            //Insertar los datos
            btnInsertar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cod = codigo.getText().toString();
                    String usuario = nombre.getText().toString();

                    ContentValues registro = new ContentValues();
                    registro.put("codigo", cod);
                    registro.put("nombre", usuario);

                    db.insert("Usuarios", null, registro);

                    codigo.setText("");
                    nombre.setText("");
                }
            });

            btnBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.execSQL("DELETE FROM Usuarios");
                }
            });

            btnActualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cod = codigo.getText().toString();
                    String usuario = nombre.getText().toString();
                    String args[] = {usuario, cod};

                    db.execSQL("UPDATE Usuarios SET nombre = ? WHERE codigo = ?", args);

                }
            });
            //Consulto todos los datos
            btnConsultar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor c = db.rawQuery("SELECT codigo, nombre FROM Usuarios", null);

                    lbConsulta.setText("");
                    if(c.moveToFirst()) {
                        int i = 0;
                        do {
                            int cod = c.getInt(0);
                            String usuario = c.getString(1);

                            lbConsulta.append(cod + " "+ usuario + "\n");
                        }
                        while (c.moveToNext());
                        c.close();
                    }
                }
            });

            // EN ESTE EJEMPLO  NO CERRAMOS LA BASE DE DATOS PORQUE TAL Y COMO ESTA HECHO LA BASE DE DATOS EL PROGRAMA DEJARIA DE FUNCIONAR

        }


    }
}