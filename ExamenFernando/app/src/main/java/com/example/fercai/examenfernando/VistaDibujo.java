package com.example.fercai.examenfernando;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fercai on 17/11/17.
 */

public class VistaDibujo extends View {

    public VistaDibujo(Context c) {super(c);}
    public VistaDibujo(Context c, AttributeSet attrs){
        super(c, attrs);
    }

    //Mi pizza es solo de base de tomate :)
    protected void onDraw(Canvas lienzo) {
        Paint miPincel = new Paint();
        miPincel.setColor(Color.RED);
        miPincel.setStyle(Paint.Style.FILL);
        lienzo.drawCircle(500, 500, 300, miPincel);
        miPincel.setColor(Color.YELLOW);
        miPincel.setStyle(Paint.Style.STROKE);
        lienzo.drawCircle(500, 500, 325, miPincel);
        miPincel.setColor(Color.BLACK);
        miPincel.setTextSize(60);
        lienzo.drawText("Pizza Denigrante solo tomate, 2DAM", 0, 900, miPincel);
    }
}
