package com.example.espacia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.saturno);
        mediaPlayer.start();

        int tiempoTranscurrir = 3000; //5 segundos
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {

                Intent intent = new Intent(getApplicationContext(), Eleccion.class);
                startActivity(intent);
                handler.removeCallbacks(null);

            }
        }, tiempoTranscurrir );//define el tiempo.




    }
}