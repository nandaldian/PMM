package com.example.fercai.ejemplospinner2;

/**
 * Created by fercai on 20/10/17.
 */

public class Persona {
    private String titulo;
    private String subtitulo;

    public Persona(String tit, String sub){
        titulo = tit;
        subtitulo = sub;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }
}
