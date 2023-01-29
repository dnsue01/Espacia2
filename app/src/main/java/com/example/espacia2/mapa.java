package com.example.espacia2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class mapa extends AppCompatActivity {
    //j1


    //j2
    // -120

    //mapa

    //centro 500

    //final 900


    static String quesos[] = {"Entretenimiento", "Ciencias y naturaleza", "Ocio y deporte", "Historia", "Arte y Literatura", "Geografia"};


    ImageView tablero;
    ImageView EntretenimeintoFalso;


    //variablles jugador1
    Ficha ficha1;
    static int x1 = 425;
    static int y1 = 0;

    static List<String> quesosJ1 = new ArrayList<>();


    //variablles jugador2
    Ficha ficha2;
    static int x2 = 425;
    static int y2 = 900;

    static List<String> quesosJ2 = new ArrayList<>();


    //primer jugador false
    static boolean turno = false;


    Bundle parametros;

    String jugadores;

    static String[] jugadoresArray;

    static String jugador1;
    static String avatar1 = "";
    static String jugador2 = "";
    static String avatar2;
    ConstraintLayout layout;
    boolean fallado;
    TextView jugadorTetxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);


        //recoger los parametros pasados
        parametros = this.getIntent().getExtras();
        if (parametros != null) {
            jugadores = parametros.getString("jugadores");
            if(avatar1.equals("")){
                avatar1 = parametros.getString("avatar1");
                avatar2 = parametros.getString("avatar2");
            }

            if(parametros.containsKey("acierto")){
                boolean fallado = parametros.getBoolean("acierto");
                if(!fallado){
                    turno = !turno;
                }
            }

        }
        jugadorTetxt = (TextView) findViewById(R.id.jugadorTetxt);

        if(jugadoresArray == null){
            jugadoresArray = jugadores.split(":");
            jugador1 = jugadoresArray[1];
            jugador2 = jugadoresArray[0];
        }


        layout = (ConstraintLayout) findViewById(R.id.tablero);
        tablero = (ImageView) findViewById(R.id.tablero_image_view);

        ficha1 = new Ficha(getApplicationContext());
        ficha2 = new Ficha(getApplicationContext());

        asignarAvatar(ficha1, avatar1, true);
        asignarAvatar(ficha2, avatar2, false);

        moverJugador();
        cambiarJugador();



    }

    private void moverJugador() {
        if(!turno){


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


        }else{
            int tiempoTranscurrir = 1000;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    y2 -=120;
                    ficha2.moverFicha(x2, y2);
                    handler.removeCallbacks(null);

                }
            }, tiempoTranscurrir);//define el tiempo.


        }

        int  tiempoTranscurrir = 1500;
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!turno){
                    Intent intent = new Intent(getApplicationContext(), ruleta.class);
                    intent.putExtra("quesosJugador", (Serializable) quesosJ1);
                    startActivity(intent);
                    handler1.removeCallbacks(null);
                }else{
                    Intent intent = new Intent(getApplicationContext(), ruleta.class);
                    intent.putExtra("quesosJugador",(Serializable) quesosJ2);
                    startActivity(intent);
                    handler1.removeCallbacks(null);
                }


            }
        }, tiempoTranscurrir);
    }

    private void cambiarJugador() {
        if(!turno){
            jugadorTetxt.setText(jugador1);
        }else{
            jugadorTetxt.setText(jugador2);
        }
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
            case "Geografia":

                break;

        }

    }
}

