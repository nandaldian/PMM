package com.example.fercai.ejerbutton1;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/*2.-Diseña una pantalla de la forma siguiente:
     una fila que contenga dos ImageButton.
     Pon una TextView vacia en el fondo de la pantalla.
     Haz que uno de los botones contenga una imagen roja y
     el evento Click sobre él colocará a rojo el color de fondo del TextView;
     el otro botón tendrá una imagen azul y colocará el color de azul el fondo del TextView..
     Para cambiar el color usa el método setBackgroundColor con los argumentos Color.RED, Color.BLUE*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);final ImageButton horde=(ImageButton) findViewById(R.id.horde);

        final ImageButton alliance=(ImageButton) findViewById(R.id.alliance);
        final TextView imabackground=(TextView) findViewById(R.id.imabackground);

        horde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imabackground.setBackgroundResource(R.color.red);

            }
        });
        alliance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imabackground.setBackgroundResource(R.color.blue);
            }
        });

    }

}