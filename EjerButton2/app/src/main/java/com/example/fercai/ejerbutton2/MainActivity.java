package com.example.fercai.ejerbutton2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioButton RButtonVerde = (RadioButton) findViewById(R.id.RadioButtonVerde);
        final RadioButton RButtonRojo = (RadioButton) findViewById(R.id.RadioButtonRojo);
        final RadioButton RButtonAzul = (RadioButton) findViewById(R.id.RadioButtonAzul);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final RadioGroup radioGroup= (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(RButtonVerde.isChecked()){
                    textView.setBackgroundResource(R.color.verde);
                }
                if(RButtonRojo.isChecked()){
                    textView.setBackgroundResource(R.color.rojo);
                }
                if(RButtonAzul.isChecked()){
                    textView.setBackgroundResource(R.color.azul);
                }
            }
        });
    }
}