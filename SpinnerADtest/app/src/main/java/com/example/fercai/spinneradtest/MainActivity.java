package com.example.fercai.spinneradtest;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AdaptadorCliente adapter;
    SQLiteDatabase db;

    static class ViewHolder{
        TextView nombre;
        TextView telefono;
    }
    Cliente datos[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteHelper cliBDh = new SQLiteHelper(this, "DBClientes", null, 1);
        db = cliBDh.getReadableDatabase();
        tratarRegistros();

        final Spinner spinner=(Spinner)findViewById(R.id.spinner);
        adapter =new AdaptadorCliente(this);
        spinner.setAdapter(adapter);


        /*Button buttonDrop=(Button)findViewById(R.id.buttonDrop);
        buttonDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("DROP TABLE IF EXISTS Clientes");
                adapter =new AdaptadorCliente(MainActivity.this);
                spinner.setAdapter(adapter);
            }
        });*/

    }

    public void tratarRegistros(){
        String[] campos = new String[] {"nombre", "telefono"};
        //String[] args = new String[] {"AAA1"};

        String cadSQL = "CREATE TABLE IF NOT EXISTS Clientes  (codigo INTEGER, nombre TEXT, telefono TEXT)";
        db.execSQL(cadSQL);

        //Llena la base de datos en caso de que esté vacia
        String count = "SELECT count(*) FROM Clientes";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount==0) {
            for (int cont = 1; cont <= 3; cont++) {
                int codigo = cont;
                String nombre = "AAA" + cont;
                String telefono = cont + "XXXXX";

                db.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                        "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
            }
        }

        Cursor c = db.query("Clientes", campos, null, null, null, null, null);
        datos=new Cliente[c.getCount()];
        int i=0;
        if (c.moveToFirst()) {

            do {
                String nombreCli = c.getString(0);
                String telefonoCli = c.getString(1);

                datos[i]=new Cliente(nombreCli,telefonoCli);
                i++;

            } while (c.moveToNext());
        }
    }

    class AdaptadorCliente extends ArrayAdapter{

        Activity context;
        @SuppressWarnings("unchecked")
        public AdaptadorCliente(Activity context) {
            super(context, R.layout.downspiner, datos);
            this.context=context;
        }

        public View getDropDownView(int posicion,View convertView,ViewGroup parent){
            return getView(posicion,convertView,parent);
        }

        public View getView(int posicion,View convertView,ViewGroup parent){
            View item=convertView;
            ViewHolder holder;
            if(item==null){
                LayoutInflater inflater=context.getLayoutInflater();
                item=inflater.inflate(R.layout.downspiner,null);

                holder=new ViewHolder();
                holder.nombre=(TextView)item.findViewById(R.id.nombre);
                holder.telefono=(TextView)item.findViewById(R.id.telf);


                item.setTag(holder);

            }
            else
                holder=(ViewHolder)item.getTag();

            holder.nombre.setText(datos[posicion].getNombre());
            holder.telefono.setText(datos[posicion].getTelf());

            return item;
        }

    }
    public static void showToast(String text, Context context) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }


}