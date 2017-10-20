package com.example.fercai.ejemplolistatitulares;

/**
 * Created by fercai on 20/10/17.
 */

public class Titular {
    private String titulo;
    private String subtitulo;
    private int imagen;
    private String ingredientes;

    public Titular(String tit, String sub, String ingredientes, int imagen){
        this.titulo = tit;
        this.subtitulo = sub;
        this.ingredientes = ingredientes;
        this.imagen = imagen;

    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }
    public int getImagen(){
        return imagen;
    }
    public String getIngredientes(){
        return ingredientes;
    }

    //SETTERS
    public void setImagen(int imagen){
        this.imagen = imagen;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setSubtitulo(String subtitulo){
        this.subtitulo = subtitulo;
    }
    public void setIngredientes(String ingredientes){
        this.ingredientes = ingredientes;
    }
    public String toString(){
        return (titulo +", " +subtitulo);
    }
}
