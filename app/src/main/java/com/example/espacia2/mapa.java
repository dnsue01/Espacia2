package com.example.espacia2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
    ImageView queso1,queso2,queso3,queso4,queso5,queso6;

    Button jugar,guardar;

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
    boolean fallado = true;
    TextView jugadorTetxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);


        queso1 = (ImageView) findViewById(R.id.queso1);
        queso2 = (ImageView) findViewById(R.id.queso2);
        queso3 = (ImageView) findViewById(R.id.queso3);
        queso4 = (ImageView) findViewById(R.id.queso4);
        queso5 = (ImageView) findViewById(R.id.queso5);
        queso6 = (ImageView) findViewById(R.id.queso6);

        queso1.setImageResource(0);
        queso2.setImageResource(0);
        queso3.setImageResource(0);
        queso4.setImageResource(0);
        queso5.setImageResource(0);
        queso6.setImageResource(0);

        //recoger los parametros pasados
        parametros = this.getIntent().getExtras();
        if (parametros != null) {
            jugadores = parametros.getString("jugadores");
           // comprobacionArchivo();
            if(avatar1.equals("")){
                avatar1 = parametros.getString("avatar1");
                avatar2 = parametros.getString("avatar2");
            }

            if(parametros.containsKey("continuar")){
                comprobacionArchivo();
                if (quesosJ1.size()>0) {
                    for (String queso : quesosJ1) {
                        asignarQuesito(queso);
                    }
                }
                if (quesosJ2.size()>0) {
                    for (String queso : quesosJ2) {
                        asignarQuesito(queso);
                    }
                }
            }

            if(parametros.containsKey("acierto")) {
                 fallado = parametros.getBoolean("acierto");

                if (!turno) {
                    quesosJ1 = (List<String>) getIntent().getSerializableExtra("quesosJugador");
                    if (quesosJ1 != null) {
                        for (String queso : quesosJ1) {
                            asignarQuesito(queso);
                        }
                    }
                } else {
                    quesosJ2 = (List<String>) getIntent().getSerializableExtra("quesosJugador");
                    if (quesosJ2 != null) {
                        for (String queso : quesosJ2) {
                            asignarQuesito(queso);
                        }
                    }
                }

            }



        }
        jugadorTetxt = (TextView) findViewById(R.id.jugadorTetxt);

        if(jugadoresArray == null){
            jugadoresArray = jugadores.split(":");
            jugador1 = jugadoresArray[0];
            jugador2 = jugadoresArray[1];

        }




        layout = (ConstraintLayout) findViewById(R.id.tablero);
        tablero = (ImageView) findViewById(R.id.tablero_image_view);

        ficha1 = new Ficha(getApplicationContext());
        ficha2 = new Ficha(getApplicationContext());

        asignarAvatar(ficha1, avatar1, true);
        asignarAvatar(ficha2, avatar2, false);

        jugar = (Button) findViewById(R.id.jugar);
        guardar = (Button) findViewById(R.id.guardar);

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!fallado) {
                    turno = !turno;
                }

                if(!turno){
                    Intent intent = new Intent(getApplicationContext(), ruleta.class);
                    intent.putExtra("quesosJugador", (Serializable) quesosJ1);
                    startActivity(intent);

                }else{
                    Intent intent = new Intent(getApplicationContext(), ruleta.class);
                    intent.putExtra("quesosJugador",(Serializable) quesosJ2);
                    startActivity(intent);
                }
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grabar();

            }
        });

        cambiarJugador();
        moverJugador();
    }

    private void comprobacionArchivo() {


        String filename =jugadores + ".txt";
        File file = new File(getApplicationContext().getFilesDir(), filename);

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {


                    String[] parts = line.split(":");

                    if (parts[0].contains("quesosJ1")) {

                            String input = parts[0];
                            int index = input.indexOf("=");
                            String value = input.substring(index + 1);
                        if(!value.equals("")){
                            quesosJ1 = Arrays.asList(value.split(","));
                        }

                    } else if (parts[0].contains("quesosJ2")) {

                        String input = parts[0];
                        int index = input.indexOf("=");
                        String value = input.substring(index + 1);

                        if(!value.equals("")){
                            quesosJ2 = Arrays.asList(value.split(","));
                        }


                    } else if (parts[0].contains("turno")) {


                        switch (parts[0].toString()){
                            case "turno=false":
                                turno = false;
                            break;
                            case "turno=true":
                                turno = true;
                                break;
                        }


                    } else if (parts[0].contains("x1")) {

                        String input = parts[0];
                        int index = input.indexOf("=");
                        String value = input.substring(index + 1);

                        x1 = Integer.parseInt(value);
                    } else if (parts[0].contains("y1")) {

                        String input = parts[0];
                        int index = input.indexOf("=");
                        String value = input.substring(index + 1);

                        y1 = Integer.parseInt(value);
                    } else if (parts[0].contains("x2")) {

                        String input = parts[0];
                        int index = input.indexOf("=");
                        String value = input.substring(index + 1);

                        x2 = Integer.parseInt(value);
                    } else if (parts[0].contains("y2")) {

                        String input = parts[0];
                        int index = input.indexOf("=");
                        String value = input.substring(index + 1);

                        y2 = Integer.parseInt(value);
                    } else if (parts[0].contains("avatar1")) {
                        String input = parts[0];
                        int index = input.indexOf("=");
                        String value = input.substring(index + 1);
                        avatar1 = value;
                    } else if (parts[0].contains("avatar2")) {
                        String input = parts[0];
                        int index = input.indexOf("=");
                        String value = input.substring(index + 1);
                        avatar2 = value;
                    }
                }
                br.close();
                // Aquí puedes asignar los valores leídos a las variables que necesitas
            } catch (IOException e) {
                e.printStackTrace();
            }

    }








    private void moverJugador() {
        if(!turno){

        int tiempoTranscurrir = 1000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(quesosJ1.size()%2 == 0){
                    y1 += 75;
                    ficha1.moverFicha(x1, y1);
                    handler.removeCallbacks(null);
                }

            }
        }, tiempoTranscurrir);//define el tiempo.


        }else{
            int tiempoTranscurrir = 1500;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(quesosJ2.size()%2 == 0){
                        y2 -=120;
                        ficha2.moverFicha(x2, y2);
                        handler.removeCallbacks(null);
                    }

                }
            }, tiempoTranscurrir);//define el tiempo.


        }


    }

    private void cambiarJugador() {
        if(!turno){
            jugadorTetxt.setText("Astronautas de  "+jugador1);
            jugar.setText(jugar.getText()+" " +jugador2);
        }else{
            jugadorTetxt.setText("Astronautas de "+jugador2);
            jugar.setText(jugar.getText()+" " +jugador1);
        }
        if(fallado){
            jugar.setText("JUGAR " +jugador1);
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


    private void asignarQuesito(String quesosJ) {

        switch (quesosJ) {
            case "Entretenimiento":
                queso1.setImageResource(R.drawable.entretenimiento);
                break;
            case "Ciencias y naturaleza":
                queso2.setImageResource(R.drawable.cienciasynaturaleza);
                break;
            case "Ocio y deporte":
                queso3.setImageResource(R.drawable.ocioydeporte);
                break;
            case "Historia":
                queso4.setImageResource(R.drawable.historia);
                break;
            case "Arte y Literatura":
                queso5.setImageResource(R.drawable.arteyliteratura);
                break;
            case "Geografia":
                queso6.setImageResource(R.drawable.geografia);
                break;

        }

    }

    public void grabar(){
        String nomarchivo = jugador1 +":"+jugador2+ ".txt";
        try {
            File file = new File(getApplicationContext().getFilesDir(), nomarchivo);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            String listJ1;
            String listJ2;

            bw.write("turno=" + turno);
            bw.newLine();
            bw.write("x1=" + x1);
            bw.newLine();
            bw.write("x2=" + x2);
            bw.newLine();
            bw.write("y1=" + y1);
            bw.newLine();
            bw.write("y2=" + y2);
            bw.newLine();
            bw.write("avatar1=" + avatar1);
            bw.newLine();
            bw.write("avatar2=" + avatar2);
            bw.newLine();
            listJ1 = String.join(",", quesosJ1);
             bw.write("quesosJ1=" + listJ1);
             bw.newLine();

             listJ2 = String.join(",", quesosJ2);
             bw.write("quesosJ2=" + listJ2);


            bw.close();
            fw.close();

            Context context = getApplicationContext();
            CharSequence text = "guardado";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}








