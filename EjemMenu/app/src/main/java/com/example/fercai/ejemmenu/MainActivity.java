package com.example.fercai.ejemmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblMensaje = (TextView)findViewById(R.id.lblMensaje);

        registerForContextMenu(lblMensaje);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_inicial, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje.setText("Opcion 1 pulsada!");
                return true;
            case R.id.MnuOpc2:
                lblMensaje.setText("Opcion 2 pulsada!");
                return true;
            case R.id.MnuOpc3:
                lblMensaje.setText("Opcion 3 pulsada!");
                return true;
            case R.id.SubMnuOpc1:
                lblMensaje.setText("Submenu: Opcion 1!");
                return true;
                case R.id.SubMnuOpc2:
                lblMensaje.setText ("Submenu: Opcion 2!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem menu) {
        switch (menu.getItemId()) {
            case R.id.CtxLblOpc1:
                lblMensaje.setText("Etiqueta: Opcion 1 pulsada!");
                return true;
            case R.id.CtxLblOpc2:
                lblMensaje.setText("Etiqueta: Opcion 2 pulsada!");
                return true;
            default:
                return super.onContextItemSelected(menu);
        }
}}