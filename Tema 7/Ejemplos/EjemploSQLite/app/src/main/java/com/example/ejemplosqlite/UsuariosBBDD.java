package com.example.ejemplosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuariosBBDD extends SQLiteOpenHelper {

    private String sqlCreate = "CREATE TABLE Usuarios(" +
            "codigo INTEGER PRIMARY KEY," +
            "nombre TEXT)";
    public UsuariosBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Se ejecuta la sentencia SQL de creacion de tabla
        db.execSQL(sqlCreate);
    }
/*NOTA: Por simplicidad del ejemplo vamos a borrar y volver a crear directamente las tablas
* de la base de datos. Sin embargo , lo normal seria migrar los datos a una tabla temporal
* , crear la tabla nueva y migrar los datos a la nueva tabla*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");

        // Se crea la nueva version de la tabla
        db.execSQL(sqlCreate);
    }
}
