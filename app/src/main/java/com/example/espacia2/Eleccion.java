package com.example.espacia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Eleccion extends AppCompatActivity {

    Button nuevaPartida;
    Button continuarPartida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion);
        nuevaPartida = (Button) findViewById(R.id.botonNueva);
        continuarPartida = (Button) findViewById(R.id.botonContinuar);


        nuevaPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NuevaPartida.class);
                startActivity(intent);
                finish();
            }

        });


        continuarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ContinuarPartida.class);
                startActivity(intent);
                finish();
            }

        });



    }
}