package com.jhoanlopez.gestiondecontactos.DataBases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
// Esta clase finalmente no la utilicé.
// Extendemos la clase 'SQLiteOpenHelper' para trabajar con bases de datos 'SQLITE'.
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "sqlite.db";
    public static final String TABLE_STREAMERS = "streamers";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase) {
        //SENTENCIA PARA CREAR UNA TABLA CON PRIMARY KEY AUTOINCREMENTAL
        sqliteDatabase.execSQL("CREATE TABLE " + TABLE_STREAMERS + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre VARCHAR(30), ciudad VARCHAR(30), estado VARCHAR(15));");

        //SENTENCIA INSERTAR DATOS 'NOMBRE, CIUDAD' EN LA TABLA CREADA ANTERIORMENTE
        sqliteDatabase.execSQL("INSERT INTO " + TABLE_STREAMERS + " (nombre, ciudad, estado) VALUES ('Auron Play', 'Barcelona', 'Activo');");
        sqliteDatabase.execSQL("INSERT INTO " + TABLE_STREAMERS + " (nombre, ciudad, estado) VALUES ('Ibai LLanos', 'Bilbao', 'Activo');");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, int oldVersion, int newVersion) {
        //SENTENCIA BORRAR TABLA 'streamers' EN LA TABLA CREADA ANTERIORMENT;
        sqliteDatabase.execSQL("DROP TABLE " + TABLE_STREAMERS);
        onCreate(sqliteDatabase);
    }
}
