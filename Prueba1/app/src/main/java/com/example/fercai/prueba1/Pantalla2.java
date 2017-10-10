package com.example.fercai.prueba1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo = (TextView) findViewById(R.id.saludo2);
        final Button BotonAtras = (Button) findViewById(R.id.Volver);
        final ImageButton ImgVolver = (ImageButton) findViewById(R.id.imgvolver);

        //showToast("estoy en pantalla2");

        Bundle recogerBundle = getIntent().getExtras();
        otroSaludo.setText(recogerBundle.getString("TEXTO"));

        Toast.makeText(this, "estoy en la pantalla2", Toast.LENGTH_SHORT).show();
        BotonAtras.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(Pantalla2.this, MainActivity.class);

                startActivity(miIntent);


    }});
        ImgVolver.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(Pantalla2.this, MainActivity.class);

                startActivity(miIntent);

            }



    /*protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }*/
        });
    }}