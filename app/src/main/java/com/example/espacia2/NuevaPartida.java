package com.example.espacia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class NuevaPartida extends AppCompatActivity {

    Button volver,Empezar;

    TextView jugador1,jugador2;

    String jugadores;
    boolean funciona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_partida);

        volver =(Button) findViewById(R.id.volver);
        Empezar =(Button) findViewById(R.id.continuar);

        jugador1 = (TextView) findViewById(R.id.jugador1);
        jugador2 = (TextView) findViewById(R.id.jugador2);



        Empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario1 = String.valueOf(jugador1.getText());
                String usuario2 = String.valueOf(jugador2.getText());

                if(usuario1.equals("") || usuario2.equals("") || usuario1.contains(":") || usuario2.contains(":") ){
                    Context context = getApplicationContext();
                    CharSequence text = "No entra";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }else{
                    jugadores = usuario1+":"+usuario2;
                    comprobar(getApplicationContext());
                    if(funciona){
                        Intent intent = new Intent(view.getContext(), SelectorPersonaje.class);
                        intent.putExtra("jugadores", jugadores);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Eleccion.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void comprobar(Context context){

            String nomarchivo = jugadores + ".txt";

            File file = new File(context.getFilesDir(), nomarchivo);

            // Si el archivo  existe, salta alerta si no existe se crea
            if (file.exists()) {

                context = getApplicationContext();
                CharSequence text = "Ya hay una partida con estos jugadores";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }else{
                crear(context);
            }
    }



    public void crear(Context context){


        try {
            String nomarchivo = jugadores + ".txt";

            File file = new File(context.getFilesDir(), nomarchivo);

            file.createNewFile();

            funciona = true;


        } catch (IOException e) {

            context = getApplicationContext();
            CharSequence text = "error";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}