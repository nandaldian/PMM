package com.example.fercai.ejemplolistatitulares;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[]{
            new Titular("Tarta de queso", "Ingredientes", "200 g queso Philadelphia; 500 ml de nata o crema de leche; 40 g de azúcar; 1 sobre de gelatina sin sabor en polvo (7 g aprox.); 150 g de galletas María; 75 g de mantequilla; vuestra cobertura preferida", R.drawable.tarta ),
            new Titular("Red Velvet", "Ingredientes","250 gr de mantequilla a temperatura ambiente, 600 gr de azúcar icing sugar, 250 gr de queso crema tipo philadelphia, 3 cucharadas de leche entera o semidesnatada (opcional).",R.drawable.tarta2 ),
            new Titular("Carrot Cake", "Ingredientes","Zanahorias medianas peladas, ralladas o picadas muy pequeñas (4), Harina (2 ½ cups o tazas – 275 g), Levadura (1 cucharadita), Bicarbonato (1 cucharadita), Canela en polvo (1 cucharadita), Azúcar (1 cup o taza – 225 g), Azúcar moreno (1 cup o taza – 200 g), Mantequilla sin sal, a temperatura ambiente (250 g), Huevos grandes, a temperatura ambiente (3), Extracto de vainilla (2 cucharaditas), Zumo de manzana o de naranja (½ cup o taza – 118 ml, aprox. medio vaso), Nata líquida para postres (3 cucharaditas)",R.drawable.tarta3)
    };
    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
        ImageView imagen;
        TextView ingredientes;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String messaje = "Titulo: " + datos[position].getTitulo() + ". Subtitulo:" + datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(), messaje, Toast.LENGTH_LONG).show();
            }

        });
    }

    class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }


        public View getView(int position, View convertView, ViewGroup parent)
            { View item = convertView;
                ViewHolder holder;
                if(item == null)
                {
                    LayoutInflater inflater = context.getLayoutInflater();
                    item = inflater.inflate(R.layout.listitem_titular, null);

                    holder = new ViewHolder();
                    holder.titulo = (TextView)item.findViewById(R.id.LblTitulo);
                    holder.subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
                    holder.imagen = (ImageView)item.findViewById(R.id.ivlimagen);
                    holder.ingredientes = (TextView)item.findViewById(R.id.LblIngredientes);
                    item.setTag(holder);
                }
                else {
                    holder = (ViewHolder) item.getTag();
                }
                holder.titulo.setText(datos[position].getTitulo());
                holder.subtitulo.setText(datos[position].getSubtitulo());
                holder.imagen.setBackground(getDrawable(datos[position].getImagen()));
                holder.ingredientes.setText(datos[position].getIngredientes());
                return(item);


        }
    }


}

