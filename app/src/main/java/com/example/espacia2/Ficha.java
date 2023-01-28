package com.example.espacia2;

import android.content.Context;

public class Ficha extends androidx.appcompat.widget.AppCompatImageView {
    private int x;
    private int y;

    public Ficha(Context context) {
        super(context);
    }

    public void moverFicha(int x, int y) {
        this.x = x;
        this.y = y;
        setX(x);
        setY(y);
    }
}
