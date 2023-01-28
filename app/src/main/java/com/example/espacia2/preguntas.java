package com.example.espacia2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class preguntas extends AppCompatActivity {


    ConstraintLayout fondo;


    String temaPregunta;


    ImageView imagen;

    TextView textViewPregunta;

    TextView respuesta1,respuesta2,respuesta3,respuesta4;

    Button comprobar;
    String[][] preguntas = new String[20][3];
    List<String> preguntasRe = new ArrayList<>();
    List<String> preguntasUsadas = new ArrayList<>();

    String respuestaVerdadera;
    String respuestaElegida;

    String todasRespuestas;
    Random r = new Random();
    int numeroR ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);


        //recoger los parametros pasados
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            temaPregunta = parametros.getString("tema");
        }

        fondo = findViewById(R.id.fondo);

        textViewPregunta = findViewById(R.id.textViewPregunta);

        respuesta1 = findViewById(R.id.respuesta1);
        respuesta2 = findViewById(R.id.respuesta2);
        respuesta3 = findViewById(R.id.respuesta3);
        respuesta4 = findViewById(R.id.respuesta4);

        comprobar = (Button) findViewById(R.id.comprobar);

        imagen =  findViewById(R.id.imageView3);
        GetColor(temaPregunta,imagen);


        getPreguntas();

        getPreguntaAleatoria();


      respuesta1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              respuestaElegida = respuesta1.getText().toString();
              respuesta1.setTextColor(Color.BLUE);
              respuesta2.setTextColor(Color.BLACK);
              respuesta3.setTextColor(Color.BLACK);
              respuesta4.setTextColor(Color.BLACK);
          }
      });

        respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuestaElegida = respuesta2.getText().toString();
                respuesta2.setTextColor(Color.BLUE);
                respuesta3.setTextColor(Color.BLACK);
                respuesta4.setTextColor(Color.BLACK);
                respuesta1.setTextColor(Color.BLACK);
            }
        });

        respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuestaElegida = respuesta3.getText().toString();

                respuesta3.setTextColor(Color.BLUE);
                respuesta4.setTextColor(Color.BLACK);
                respuesta1.setTextColor(Color.BLACK);
                respuesta2.setTextColor(Color.BLACK);
            }
        });

        respuesta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { respuesta1.setTextColor(Color.BLUE);
                respuestaElegida = respuesta4.getText().toString();
                respuesta4.setTextColor(Color.BLUE);
                respuesta1.setTextColor(Color.BLACK);
                respuesta2.setTextColor(Color.BLACK);
                respuesta3.setTextColor(Color.BLACK);
            }
        });
        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaElegida = respuestaElegida.trim();
                if(respuestaElegida!=null){
                    if(respuestaElegida.equals(respuestaVerdadera)){
                        Context context = getApplicationContext();
                        CharSequence text = "Acierto!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }else{
                        Context context = getApplicationContext();
                        CharSequence text = "Fallo! la respuesta era "+respuestaVerdadera;
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Necisitas elegir una respuesta!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }

    private void getPreguntaAleatoria() {

        boolean encontrada = true;
        while(encontrada){
            numeroR =  r.nextInt(preguntasRe.size());

            if(!preguntasUsadas.contains(preguntas[numeroR][0])){

                respuestaVerdadera = preguntas[numeroR][1];
                respuestaVerdadera = respuestaVerdadera.trim();
                todasRespuestas = preguntas[numeroR][2];

                RespuestasAleatorias(todasRespuestas);

                textViewPregunta.setText(preguntas[numeroR][0]);
                preguntasUsadas.add(preguntas[numeroR][0]);
                encontrada = false;

            }
        }



    }

    private void RespuestasAleatorias(String todasRespuestas) {

        String [] respuestas = todasRespuestas.split(",");

        List<String> respuestasAle = Arrays.asList(respuestas);

        Collections.shuffle(respuestasAle);

        respuestasAle.toArray(respuestas);

        respuesta1.setText(respuestas[0]);
        respuesta2.setText(respuestas[1]);
        respuesta3.setText(respuestas[2]);
        respuesta4.setText(respuestas[3]);

    }

    private void getPreguntas() {
        BaseDeDatos datab= new BaseDeDatos(getApplicationContext());
        SQLiteDatabase db= datab.getWritableDatabase();

        datab.insertDB();
        //Para sacar las respuestas con las preguntas simplemente seria cambiando el select y añadiendo un + despues de PREGUNTAS
        String selectQuery = "SELECT PREGUNTAS , RESPUESTAS,OPCIONES FROM  Preguntas_Respuestas_Opciones  WHERE TIPO  = '"+temaPregunta+"'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        //Recorro el cursor uno por uno para sacar los datos de uno en uno
        int i = 0;
        if(cursor.moveToFirst()){
            do{
                String pregunta = cursor.getString(0);
                String respuesta = cursor.getString(1);
                String op = cursor.getString(2);

                if(!preguntasRe.contains(pregunta)){

                    preguntas[i][0] = pregunta;
                    preguntas[i][1] = respuesta;
                    preguntas[i][2] = op;
                    preguntasRe.add(pregunta);

                    i++;
                }

                //Aquí puedes hacer lo que quieras con las preguntas y respuestas recuperadas
            }while(cursor.moveToNext());
        }
        cursor.close();

    }


    private  void  GetColor(String pregunta,ImageView imagen){

        switch (pregunta){
            case "Ciencias y naturaleza":
                imagen.setImageResource(R.drawable.cienciafrag);
                break;
            case "Arte y Literatura":
                imagen.setImageResource(R.drawable.literaturafrag);
                break;
            case "Ocio y deporte":
                imagen.setImageResource(R.drawable.deportefrag);
                break;
            case "Historia":
                imagen.setImageResource(R.drawable.historiafrag);
                break;
            case "Entretenimiento":
                imagen.setImageResource(R.drawable.entretenimientofrag);
                break;
            case "Geografía":
                imagen.setImageResource(R.drawable.geografiafrag);
                break;
        }

    }



}