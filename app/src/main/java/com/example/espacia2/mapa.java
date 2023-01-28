package com.example.espacia2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class mapa extends AppCompatActivity {
    //j1


    //j2
    // -120

    //mapa

    //centro 500

    //final 900


    static String quesos[] = {"Entretenimiento", "Ciencias y naturaleza", "Ocio y deporte", "Historia", "Arte y Literatura", "Geografía"};


    ImageView tablero;
    ImageView EntretenimeintoFalso;


    //variablles jugador1
    Ficha ficha1;
    static int x1 = 425;
    static int y1 = 0;

    static String quesosJ1[] = new String[quesos.length];


    //variablles jugador2
    Ficha ficha2;
    static int x2 = 425;
    static int y2 = 900;

    static String quesosJ2[] = new String[quesos.length];


    //primer jugador false
    boolean turno = false;


    Bundle parametros;

    String jugadores;

    String jugador1, avatar1;
    String jugador2, avatar2;

    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);


        //recoger los parametros pasados
        parametros = this.getIntent().getExtras();
        if (parametros != null) {
            jugadores = parametros.getString("jugadores");
            avatar1 = parametros.getString("avatar1");
            avatar2 = parametros.getString("avatar2");

        }


        String[] jugadoresArray = jugadores.split(":");
        jugador1 = jugadoresArray[1];
        jugador2 = jugadoresArray[0];

        layout = (ConstraintLayout) findViewById(R.id.tablero);
        tablero = (ImageView) findViewById(R.id.tablero_image_view);

        ficha1 = new Ficha(getApplicationContext());
        ficha2 = new Ficha(getApplicationContext());

        asignarAvatar(ficha1, avatar1, true);
        asignarAvatar(ficha2, avatar2, false);


        int tiempoTranscurrir = 1000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                y1 += 75;
                ficha1.moverFicha(x1, y1);
                handler.removeCallbacks(null);

            }
        }, tiempoTranscurrir);//define el tiempo.

        tiempoTranscurrir = 1500;
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), ruleta.class);
                startActivity(intent);
                handler1.removeCallbacks(null);

            }
        }, tiempoTranscurrir);

    }

    private void asignarAvatar(Ficha ficha1, String avatar, boolean jugador) {

        switch (avatar) {
            case "personaje1":
                ficha1.setImageResource(R.drawable.personaje1);
                break;
            case "personaje2":
                ficha1.setImageResource(R.drawable.personaje2);
                break;
            case "personaje3":
                ficha1.setImageResource(R.drawable.personaje3);
                break;
            case "personaje4":
                ficha1.setImageResource(R.drawable.personaje4);
                break;
            case "personaje5":
                ficha1.setImageResource(R.drawable.personaje5);
                break;
            case "personaje6":
                ficha1.setImageResource(R.drawable.perosnaje6);
                break;

        }


        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(200, 200); // Width , height
        ficha1.setLayoutParams(params);
        layout.addView(ficha1);

        if (jugador) {
            ficha1.moverFicha(x1, y1);
        } else {
            ficha1.moverFicha(x2, y2);
        }
    }


    private void asignarQuesito(String quesito) {

        switch (quesito) {
            case "Entretenimiento":

                break;
            case "Ciencias y naturaleza":

                break;
            case "Ocio y deporte":

                break;
            case "Historia":

                break;
            case "Arte y Literatura":

                break;
            case "Geografía":

                break;

        }

    }
}

