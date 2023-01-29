package com.example.espacia2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ruleta extends AppCompatActivity {

    ImageView ruleta;
    Button boton;

    String premios[] = {"Entretenimiento","Ciencias y naturaleza","Ocio y deporte","Historia","Arte y Literatura","Geografia"};
    List<String> premiosFaltantes = new ArrayList<>(Arrays.asList("Entretenimiento", "Ciencias y naturaleza", "Ocio y deporte", "Historia", "Arte y Literatura", "Geografia"));
    int[] gradosSectores = new int[premios.length];
    Random random = new Random();
    int grado = 0;
    boolean girando = false;

    String temaPregunta;

    Bundle parametros;

    static int contador = 0;

    boolean acierto;

    ImageView estrella1,estrella2,estrella3;

    List<String> quesosJugador ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta);


        parametros = getIntent().getExtras();
        if(parametros !=null){

            acierto =  parametros.getBoolean("acierto");
            if(acierto){
                contador++;
            }else{
                contador = 0;
            }
            quesosJugador=   (List<String>) getIntent().getSerializableExtra("quesosJugador");
        }


        ruleta = (ImageView) findViewById(R.id.imageView);
        boton = (Button) findViewById(R.id.button);

        estrella1 =  (ImageView) findViewById(R.id.estrella1);
        estrella2 =  (ImageView) findViewById(R.id.estrella2);
        estrella3 =  (ImageView) findViewById(R.id.estrella3);


        getGrado();

        getEstrellas();
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

    private void getEstrellas() {
        switch (contador){
            case 1:
                estrella1.setImageResource(R.drawable.estrella);
                break;
            case 2:
                estrella1.setImageResource(R.drawable.estrella);
                estrella2.setImageResource(R.drawable.estrella);
                break;
            case 3:
                estrella1.setImageResource(R.drawable.estrella);
                estrella2.setImageResource(R.drawable.estrella);
                estrella3.setImageResource(R.drawable.estrella);

                mostrarPremiosFaltantes();
                break;
        }
    }



        private void mostrarPremiosFaltantes() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Premios que te faltan");
            List<String> premiosFaltantes = new ArrayList<>(Arrays.asList("Entretenimiento", "Ciencias y naturaleza", "Ocio y deporte", "Historia", "Arte y Literatura", "Geografia"));

            if (quesosJugador != null) {
                premiosFaltantes.removeAll(quesosJugador);
            }

            if (premiosFaltantes.isEmpty()) {
                Toast.makeText(this, "Tienes todos los premios", Toast.LENGTH_SHORT).show();
            } else {
                ImageListAdapter adapter = new ImageListAdapter(this, premiosFaltantes);
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String premioSeleccionado = premiosFaltantes.get(which);
                        Toast.makeText(getApplicationContext(), "Has seleccionado: " + premioSeleccionado, Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }

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


                int tiempoTranscurrir = 1000; //1 segundos
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run()
                    {

                        girando = false;
                        temaPregunta = premios[premios.length-(grado+1)];

                        Intent intent = new Intent(getApplicationContext(), preguntas.class);
                        intent.putExtra("tema", temaPregunta);
                        startActivity(intent);
                        finish();
                    }
                }, tiempoTranscurrir );//define el tiempo.

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



    public class ImageListAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final List<String> premiosFaltantes;

        public ImageListAdapter(Context context, List<String> premiosFaltantes) {
            super(context, -1, premiosFaltantes);
            this.context = context;
            this.premiosFaltantes = premiosFaltantes;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.image_list_item, parent, false);
            TextView textView = rowView.findViewById(R.id.premio_text);
            ImageView imageView = rowView.findViewById(R.id.premio_icon);
            textView.setText(premiosFaltantes.get(position));
            int resID = context.getResources().getIdentifier(premiosFaltantes.get(position).replace(" ","").toLowerCase(), "drawable", context.getPackageName());
            imageView.setImageResource(resID);
            return rowView;
        }
    }






    }

