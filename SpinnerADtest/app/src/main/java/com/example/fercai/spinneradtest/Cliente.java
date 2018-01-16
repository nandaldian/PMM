package com.example.fercai.spinneradtest;

/**
 * Created by fercai on 16/01/18.
 */

public class Cliente {

    String nombre;
    String telefono;

    public Cliente(String nombre,String telefono){
        this.nombre=nombre;
        this.telefono=telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTelf(){
        return telefono;
    }

}