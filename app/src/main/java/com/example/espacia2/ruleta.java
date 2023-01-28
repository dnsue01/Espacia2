package com.example.espacia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class ruleta extends AppCompatActivity {

    ImageView ruleta;
    Button boton;

    String premios[] = {"Entretenimiento","Ciencias y naturaleza","Ocio y deporte","Historia","Arte y Literatura","Geografía"};
    int[] gradosSectores = new int[premios.length];
    Random random = new Random();
    int grado = 0;
    boolean girando = false;

    String temaPregunta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta);

        ruleta = (ImageView) findViewById(R.id.imageView);
        boton = (Button) findViewById(R.id.button);

        getGrado();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!girando){
                    girar();
                    girando = true;
                }
            }
        });

    }

    private void girar(){

        grado = random.nextInt(premios.length);


        RotateAnimation rotate = new RotateAnimation(0,(360* gradosSectores.length)+gradosSectores[grado],RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);

        rotate.setDuration(2000);
        rotate.setInterpolator(new DecelerateInterpolator());
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                girando = false;
                temaPregunta = premios[premios.length-(grado+1)];

                Intent intent = new Intent(getApplicationContext(), preguntas.class);
                intent.putExtra("tema", temaPregunta);
                startActivity(intent);
                finish();


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ruleta.startAnimation(rotate);
    }


    private void getGrado(){

        int sectorGrado = 360/premios.length;

        for (int i = 0;i<premios.length;i++){
            gradosSectores[i] = (i+1)*sectorGrado;
        }
    }

}