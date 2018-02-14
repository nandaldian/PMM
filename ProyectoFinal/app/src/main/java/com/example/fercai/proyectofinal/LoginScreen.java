package com.example.fercai.proyectofinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    private BDHelper cliBDh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        Button registrarse=(Button)findViewById(R.id.registro);
        Button volver_login=(Button)findViewById(R.id.volver_login);
        final EditText registro_cliente=(EditText)findViewById(R.id.registro_cliente);
        final EditText registro_contraseña=(EditText)findViewById(R.id.registro_contraseña);

        cliBDh = new BDHelper(this, "Clientes", null, 1);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = cliBDh.getWritableDatabase();
                bd.execSQL("INSERT INTO Clientes (cliente, password) VALUES ('"+registro_cliente.getText().toString()+"','"+registro_contraseña.getText().toString()+"')");
                bd.close();
                Intent volver= new Intent(LoginScreen.this,MainActivity.class);
                startActivity(volver);
            }
        });

        volver_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retornar= new Intent(LoginScreen.this,MainActivity.class);
                startActivity(retornar);
            }
        });
    }
}