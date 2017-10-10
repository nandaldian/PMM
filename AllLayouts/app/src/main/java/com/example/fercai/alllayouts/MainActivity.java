package com.example.fercai.alllayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button botonTabla= (Button)findViewById(R.id.botonTabla);
        final Button botonRelative= (Button)findViewById(R.id.botonRelative);
        final Button botonGrid= (Button)findViewById(R.id.botonGrid);
        final ImageButton ImgLinear = (ImageButton) findViewById(R.id.linearlayout);
        final Button botonCheckbox= (Button)findViewById(R.id.botonCheckbox);

       botonTabla.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Tabla.class);

                startActivity(miIntent);
            }});

        botonRelative.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Relative.class);

                startActivity(miIntent);
            }});

        botonGrid.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Grid.class);

                startActivity(miIntent);
            }});
        ImgLinear.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Linear.class);

                startActivity(miIntent);

            }



    /*protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }*/
        });

        botonCheckbox.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Checkbox.class);

                startActivity(miIntent);
            }});


    }
}
