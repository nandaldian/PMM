package com.example.fercai.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDHelper extends SQLiteOpenHelper {
    String consulta= "CREATE TABLE Clientes (id INTEGER PRIMARY KEY AUTOINCREMENT,cliente TEXT, password TEXT)";
    String consulta2= "CREATE TABLE Moviles (Marca TEXT, Modelo TEXT, Precio DOUBLE)";
    String consulta3="CREATE TABLE Ventas (clientes TEXT, Marca TEXT, Modelo TEXT, Precio DOUBLE" +
            ", FOREIGN KEY (clientes) REFERENCES Clientes (id))";

    public BDHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(consulta);
        bd.execSQL(consulta2);
        bd.execSQL(consulta3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        bd.execSQL(consulta);

    }

}