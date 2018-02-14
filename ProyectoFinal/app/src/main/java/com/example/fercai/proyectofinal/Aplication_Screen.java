package com.example.fercai.proyectofinal;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Aplication_Screen extends AppCompatActivity implements Fragment_Dinamico.OnFragmentInteractionListener {

    private Graficas[]listado;
    public ArrayList<Graficas> moviles= new ArrayList<Graficas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplication__screen);

        final Button boton_comprar = (Button) findViewById(R.id.boton_comprar);

        BDHelper cliBDh = new BDHelper(this, "Clientes", null, 1);

        SQLiteDatabase bd = cliBDh.getWritableDatabase();

        Toast.makeText(getApplicationContext(),"completado",Toast.LENGTH_LONG).show();

        String[] campos = new String[] {"Marca", "Modelo", "Precio"};
        Cursor c = bd.query("Graficas", campos, null, null, null, null, null);
        listado=new Graficas[c.getCount()];
        int i=0;
        if (c.moveToFirst()) {
            do {
                String marca = c.getString(0);
                String modelo = c.getString(1);
                Double precio=c.getDouble(2);

                listado[i]= new Graficas(marca,modelo,precio);

                i++;

            } while (c.moveToNext());
        }

        AdaptadorJuegos adaptador = new AdaptadorJuegos(this);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Marca: " + listado[position].getMarca() + ", Modelo: " + listado[position].getModelo()+ ", Precio: " +listado[position].getPrecio();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bd.close();

        boton_comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle objetos= new Bundle();

                Graficas datos= new Graficas(listado[spinner.getSelectedItemPosition()].getMarca(),
                        listado[spinner.getSelectedItemPosition()].getModelo(),
                        listado[spinner.getSelectedItemPosition()].getPrecio());

                objetos.putSerializable("informacion",datos);
                RadioButton efectivo=(RadioButton)findViewById(R.id.pago_efectivo);
                RadioButton tarjeta=(RadioButton)findViewById(R.id.pago_tarjeta);
                RadioGroup grupo=(RadioGroup)findViewById(R.id.radiogroup);

                if(grupo.getCheckedRadioButtonId()==R.id.pago_efectivo){
                    objetos.putString("grupo",efectivo.getText().toString());
                }else {
                    objetos.putString("grupo", tarjeta.getText().toString());
                }

                String usu= getIntent().getStringExtra("cliente");
                objetos.putSerializable("cliente",usu);

                FragmentManager fragmentmanager =getFragmentManager();
                FragmentTransaction transaction =fragmentmanager.beginTransaction();
                Fragment_Dinamico fragment= new Fragment_Dinamico();
                fragment.setArguments(objetos);

                transaction.add(R.id.activity_pantalla__aplicacion,fragment);

                transaction.commit();
            }
        });

    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_acerca:
                Intent acerca = new Intent(Aplication_Screen.this, AcercaDe.class);
                startActivity(acerca);
                return true;
            case R.id.menu_internet:
                Intent internet = new Intent(Aplication_Screen.this, Noticias.class);
                startActivity(internet);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class AdaptadorJuegos extends ArrayAdapter {

        Activity context;

        AdaptadorJuegos(Activity context) {

            super(context, R.layout.graficas, listado);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.graficas, null);

            TextView tit = (TextView) item.findViewById(R.id.grafica_marca);
            tit.setText(listado[i].getMarca());

            TextView gen = (TextView) item.findViewById(R.id.grafica_modelo);
            gen.setText(listado[i].getModelo());

            TextView pre = (TextView) item.findViewById(R.id.grafica_precio);
            pre.setText(String.valueOf(listado[i].getPrecio()));

            return (item);
        }
    }
}