package com.example.fercai.alllayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Linear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        final Button botonPrueba= (Button)findViewById(R.id.botonPrueba);
        final CheckBox CheckVerde= (CheckBox) findViewById(R.id.checkPrueba);

        botonPrueba.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                CheckVerde.setVisibility(View.VISIBLE);


            }});
    }
}
