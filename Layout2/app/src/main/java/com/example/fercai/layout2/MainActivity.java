package com.example.fercai.layout2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AÑADIENDO FUNCIONALIDAD AL BOTON
        final Button botonPrueba = (Button)findViewById(R.id.botonPrueba);
        final TextView etiquetaPrueba = (TextView)findViewById(R.id.etiquetaPrueba);

        botonPrueba.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                etiquetaPrueba.setText("Hola");


            }
        });
    }
}
