package com.example.espacia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class SelectorPersonaje extends AppCompatActivity {
    Bundle parametros;
    String jugadores;
    String jugador1,avatar1;
    String jugador2 = "",avatar2 = "";

    boolean seleccionado = false;

    TextView jugadorActual;
    ImageView personaje1,personaje2,personaje3,personaje4,personaje5,personaje6;

    Button seleccionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_personaje);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.laser);




        //recoger los parametros pasados
        parametros = this.getIntent().getExtras();
        if(parametros !=null){
            jugadores = parametros.getString("jugadores");
        }


        String[] jugadoresArray = jugadores.split(":");
        jugador1 = jugadoresArray[1];
        jugador2 = jugadoresArray[0];



        personaje1 = (ImageView) findViewById(R.id.personaje1);
        personaje2 = (ImageView) findViewById(R.id.personaje2);
        personaje3 = (ImageView) findViewById(R.id.personaje3);
        personaje4 = (ImageView) findViewById(R.id.personaje4);
        personaje5 = (ImageView) findViewById(R.id.personaje5);
        personaje6 = (ImageView) findViewById(R.id.personaje6);


        seleccionar = (Button) findViewById(R.id.seleccionar);

        jugadorActual = (TextView) findViewById(R.id.jugadorActual);
        jugadorActual.setText(jugador1);





        seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!avatar1.equals("")){



                seleccionado = true;
                jugadorActual.setText(jugador2);
                comrpobarAvatar(avatar1);




                if(!avatar1.equals(avatar2)){

                    if(!avatar2.equals("")){
                        Intent intent = new Intent(view.getContext(), mapa.class);
                        intent.putExtra("jugadores", jugadores);
                        intent.putExtra("avatar1",avatar1);
                        intent.putExtra("avatar2",avatar2);

                        startActivity(intent);
                        finish();
                    }else{
                        Context context = getApplicationContext();
                        CharSequence text = "Tienes que elegir un avatar";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }



                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "No puedes elegir el mismo avatar";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Tienes que elegir un avatar";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }

        });







        //dar click encima de la imagen

        personaje1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!seleccionado){
                    avatar1 = "personaje1";

                }else{
                    avatar2 = "personaje1";
                }

                personaje1.setImageResource(R.drawable.personaje1);
                personaje2.setImageResource(R.drawable.personaje2seleccionado);
                personaje3.setImageResource(R.drawable.personaje3seleccionado);
                personaje4.setImageResource(R.drawable.personaje4seleccionado);
                personaje5.setImageResource(R.drawable.personaje5seleccionado);
                personaje6.setImageResource(R.drawable.personaje6seleccionado);

                comrpobarAvatar(avatar1);
                mediaPlayer.seekTo(1000);
                mediaPlayer.start();


            }
        });
        personaje2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!seleccionado){
                    avatar1 = "personaje2";

                }else{

                    avatar2 = "personaje2";
                }




                personaje2.setImageResource(R.drawable.personaje2);
                personaje1.setImageResource(R.drawable.personaje1seleccionado);
                personaje3.setImageResource(R.drawable.personaje3seleccionado);
                personaje4.setImageResource(R.drawable.personaje4seleccionado);
                personaje5.setImageResource(R.drawable.personaje5seleccionado);
                personaje6.setImageResource(R.drawable.personaje6seleccionado);
                comrpobarAvatar(avatar1);


                mediaPlayer.seekTo(1000);
                mediaPlayer.start();
            }
        });
        personaje3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!seleccionado){
                    avatar1 = "personaje3";
                }else{
                    avatar2 = "personaje3";
                }


                personaje3.setImageResource(R.drawable.personaje3);
                personaje1.setImageResource(R.drawable.personaje1seleccionado);
                personaje2.setImageResource(R.drawable.personaje2seleccionado);
                personaje4.setImageResource(R.drawable.personaje4seleccionado);
                personaje5.setImageResource(R.drawable.personaje5seleccionado);
                personaje6.setImageResource(R.drawable.personaje6seleccionado);


                comrpobarAvatar(avatar1);
                mediaPlayer.seekTo(1000);
                mediaPlayer.start();
            }
        });
        personaje4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!seleccionado){
                    avatar1 = "personaje4";
                }else{
                    avatar2 = "personaje4";
                }



                personaje4.setImageResource(R.drawable.personaje4);
                personaje1.setImageResource(R.drawable.personaje1seleccionado);
                personaje2.setImageResource(R.drawable.personaje2seleccionado);
                personaje3.setImageResource(R.drawable.personaje3seleccionado);
                personaje5.setImageResource(R.drawable.personaje5seleccionado);
                personaje6.setImageResource(R.drawable.personaje6seleccionado);
                comrpobarAvatar(avatar1);
                mediaPlayer.seekTo(1000);
                mediaPlayer.start();
            }
        });
        personaje5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!seleccionado){
                    avatar1 = "personaje5";
                }else{
                    avatar2 = "personaje5";
                }

                personaje5.setImageResource(R.drawable.personaje5);
                personaje1.setImageResource(R.drawable.personaje1seleccionado);
                personaje2.setImageResource(R.drawable.personaje2seleccionado);
                personaje3.setImageResource(R.drawable.personaje3seleccionado);
                personaje4.setImageResource(R.drawable.personaje4seleccionado);
                personaje6.setImageResource(R.drawable.personaje6seleccionado);

                comrpobarAvatar(avatar1);

                mediaPlayer.seekTo(1000);
                mediaPlayer.start();
            }
        });
        personaje6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!seleccionado){
                    avatar1 = "personaje6";
                }else{
                    avatar2 = "personaje6";
                }


                personaje6.setImageResource(R.drawable.perosnaje6);
                personaje1.setImageResource(R.drawable.personaje1seleccionado);
                personaje2.setImageResource(R.drawable.personaje2seleccionado);
                personaje3.setImageResource(R.drawable.personaje3seleccionado);
                personaje4.setImageResource(R.drawable.personaje4seleccionado);
                personaje5.setImageResource(R.drawable.personaje5seleccionado);

                comrpobarAvatar(avatar1);
                mediaPlayer.seekTo(1000);
                mediaPlayer.start();
            }
        });


    }

    private void comrpobarAvatar(String avatar) {

        switch (avatar){
            case "personaje1":
                personaje1.setImageResource(R.drawable.personaje1);
                break;
            case "personaje2":
                personaje2.setImageResource(R.drawable.personaje2);
                break;
            case "personaje3":
                personaje3.setImageResource(R.drawable.personaje3);
                break;
            case "personaje4":
                personaje4.setImageResource(R.drawable.personaje4);
                break;
            case "personaje5":
                personaje5.setImageResource(R.drawable.personaje5);
                break;
            case "personaje6":
                personaje6.setImageResource(R.drawable.perosnaje6);
                break;
        }

    }

}