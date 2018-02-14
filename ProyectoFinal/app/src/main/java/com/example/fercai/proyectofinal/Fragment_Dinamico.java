package com.example.fercai.proyectofinal;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Dinamico extends Fragment {
    Integer[] id;
    private OnFragmentInteractionListener mListener;

    Button aceptar,cancelar,comprar;
    Activity activity;
    RelativeLayout layout;
    TextView marca,modelo,precio,radio;
    BDHelper cliBDh;

    public Fragment_Dinamico() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_fragment__dinamico, container, false);

        aceptar=(Button)view.findViewById(R.id.confirmar_compra);
        cancelar=(Button)view.findViewById(R.id.cancelar_compra);
        comprar=(Button)view.findViewById(R.id.boton_comprar);
        layout=(RelativeLayout)view.findViewById(R.id.layout_fragment);

        marca=(TextView)view.findViewById(R.id.grafica_marca);
        modelo=(TextView)view.findViewById(R.id.grafica_modelo);
        precio=(TextView)view.findViewById(R.id.grafica_precio);
        radio=(TextView)view.findViewById(R.id.resultado_pago);

        final EditText cliente=(EditText)view.findViewById(R.id.registro_cliente);

        final Bundle mibundle=this.getArguments();
        final Graficas graficas = (Graficas) mibundle.getSerializable("informacion");

        marca.setText("Marca: "+graficas.getMarca());
        modelo.setText("Modelo: "+graficas.getModelo());
        precio.setText("Precio: "+graficas.getPrecio()+" €/Unidad");

        radio.setText(this.getArguments().getString("grupo"));

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activity=getActivity();
                Toast.makeText(activity,"COMPRA RELIZADA!!",Toast.LENGTH_LONG).show();
                Toast.makeText(activity,"MUCHAS GRACIAS POR TU COMPRA!",Toast.LENGTH_LONG).show();

                layout.setVisibility(View.INVISIBLE);

                cliBDh = new BDHelper(getActivity().getApplicationContext(), "Clientes", null, 1);

                SQLiteDatabase bd = cliBDh.getWritableDatabase();

                Cursor cursor = bd.rawQuery("SELECT id FROM Clientes where cliente= '" +mibundle.getString("cliente")+ "';", null);

                id = new Integer[cursor.getCount()];

                if(cursor.moveToFirst()) {
                    do {
                        String ids = cursor.getString(0);
                        id[0] = Integer.parseInt(ids);
                    } while (cursor.moveToNext());
                    try {
                        bd.execSQL("INSERT INTO Ventas (Clientes,Marca,Modelo,Precio,Forma_pago) VALUES" +
                                " ('"+id[0]+"','" + graficas.getMarca() + "','" + graficas.getModelo() + "','" + graficas.getPrecio() + "','" + radio.getText() + "')");

                        Toast.makeText(getActivity().getApplicationContext(), "VENTA COMPLETADA", Toast.LENGTH_LONG).show();

                    }catch (Exception e){
                        e.getMessage();

                    }
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.INVISIBLE);

            }
        });
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}