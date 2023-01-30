package com.example.espacia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ContinuarPartida extends AppCompatActivity {
    Button volver,continuar;

    TextView jugador1,jugador2;


    String jugadores;
    String continuarT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuar_partida);
        volver = (Button) findViewById(R.id.volver);
        continuar = (Button) findViewById(R.id.continuar);
        jugador1 = (TextView) findViewById(R.id.jugador11);
        jugador2 = (TextView) findViewById(R.id.jugador12);



       continuarT = "continuar";






        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario1 = String.valueOf(jugador1.getText());
                String usuario2 = String.valueOf(jugador2.getText());

                if(usuario1.equals("") || usuario2.equals("") || usuario1.contains(":") || usuario2.contains(":") ){
                    Context context = getApplicationContext();
                    CharSequence text = "Debes de escribir algo";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }else{
                    jugadores = usuario1+":"+usuario2;
                    comprobar(view);
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



    public void comprobar(View view){

        String nomarchivo = jugadores + ".txt";

        File file = new File(getApplicationContext().getFilesDir(), nomarchivo);

        // Si el archivo no existe
        if (!file.exists()) {


            CharSequence text = "no hay ninguna partida con estos jugadores preuba a crear una";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
        }else{
            Intent intent = new Intent(view.getContext(), mapa.class);
            intent.putExtra("jugadores", jugadores);
            intent.putExtra("continuar", continuarT);
            startActivity(intent);
            finish();
        }
    }
}