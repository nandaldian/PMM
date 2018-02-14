package com.example.fercai.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BDHelper cliBDh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button entrar= (Button)findViewById(R.id.Entrar);
        Button formulario= (Button)findViewById(R.id.ir_a_registro);
        final EditText verificar_cliente=(EditText)findViewById(R.id.verificar_cliente);
        final EditText verificar_contraseña=(EditText)findViewById(R.id.verificar_contraseña);

        cliBDh = new BDHelper(this, "Clientes", null, 1);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase bd = cliBDh.getWritableDatabase();

                String cliente=verificar_cliente.getText().toString();
                String contraseña=verificar_contraseña.getText().toString();

                Cursor fila=bd.rawQuery("SELECT cliente,password FROM Clientes WHERE cliente='"+cliente+"' and password='"+contraseña+"'",null);

                if(fila.moveToFirst()) {
                    String cli = fila.getString(0);
                    String pass = fila.getString(1);

                    if (cliente.equals(cli)&&contraseña.equals(pass)) {

                        Intent adelante= new Intent(MainActivity.this,Aplication_Screen.class);
                        adelante.putExtra("cliente", cli);
                        startActivity(adelante);
                    }else {
                        Toast.makeText(getApplicationContext(),"completado",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        formulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventana = new Intent(MainActivity.this,LoginScreen.class);
                startActivity(ventana);
            }
        });

    }
}