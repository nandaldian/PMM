package com.example.fercai.proyectofinal;
import java.io.Serializable;

public class Graficas implements Serializable{

    String marca,modelo;
    Double precio;

    public Graficas(String marca, String modelo, Double precio){
        this.marca=marca;
        this.modelo=modelo;
        this.precio=precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Graficas{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                '}';
    }
}