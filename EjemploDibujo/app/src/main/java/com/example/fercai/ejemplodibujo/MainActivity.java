package com.example.fercai.ejemplodibujo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    private BitmapDrawable miImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
            setBackgroundResource(R.drawable.degradado);
            Resources res = contexto.getResources();
            miImagen = (BitmapDrawable) res.getDrawable(R.drawable.ok);
            miImagen.setBounds(new Rect(30, 30, 150, 150));
        }
        @Override
        protected void onDraw(Canvas canvas) {
            //Dentro de este metodo utilizamos los metodos para dibujar las figuras.
            //Creamos un pince1 con el cual elegiremos el trazo, estilo, color, etc.
            Paint pince1 = new Paint();
            Paint pince2 = new Paint();
            //Establecemos el color para la figura.
            pince1.setColor(Color.YELLOW);
            pince2.setColor(Color.RED);
            //Establecemos el grosor de la linea.
            pince1.setStrokeWidth(7);
            pince2.setStrokeWidth(20);
            //Establecemos el estilo del trazo.
            pince1.setStyle(Paint.Style.STROKE);
            pince2.setStyle(Paint.Style.STROKE);
            for (int i=0; i < 10; i++)
                canvas.drawCircle(300+i*100,300+i*100,280+i*100, pince1);


            canvas.drawLine(1000, 1000, 500, 500, pince1);

            miImagen.draw(canvas);

            pince1.setTextSize(70);
            canvas.drawText("Mi Primera Piruleta", 200, 1100, pince1);
            String mensaje = "Ancho: " + getWidth() + " Alto: " + getHeight();
            canvas.drawText(mensaje, 200, 1300, pince1);

            Path path = new Path();
            path.moveTo(500, 500);
            path.lineTo(100, 100);
            path.lineTo(100, 50);

            canvas.drawPath(path, pince2);

            canvas.drawOval(new RectF(500, 500, 200, 100), pince2);
        }
    }
}