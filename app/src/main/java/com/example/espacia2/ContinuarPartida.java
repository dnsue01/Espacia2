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

    String[][] preguntas = new String[20][3];
    List<String> preguntasRe = new ArrayList<>();
    String jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuar_partida);
        volver = (Button) findViewById(R.id.volver);
        continuar = (Button) findViewById(R.id.continuar);
        jugador1 = (TextView) findViewById(R.id.jugador11);
        jugador2 = (TextView) findViewById(R.id.jugador12);




        BaseDeDatos datab= new BaseDeDatos(ContinuarPartida.this);
        SQLiteDatabase db= datab.getWritableDatabase();

        datab.insertDB();
        //Para sacar las respuestas con las preguntas simplemente seria cambiando el select y añadiendo un + despues de PREGUNTAS
        String selectQuery = "SELECT PREGUNTAS , RESPUESTAS,OPCIONES FROM  Preguntas_Respuestas_Opciones  WHERE TIPO  = 'Geografia'";
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


        Context context = getApplicationContext();
        CharSequence text = "Pregunta "+preguntas[0][0]+" Respuesta v"+preguntas[0][1];
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


        continuar.setOnClickListener(new View.OnClickListener() {
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

        // Si el archivo no existe
        if (!file.exists()) {

            context = getApplicationContext();
            CharSequence text = "no hay ninguna partida con estos jugadores preuba a crear una";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}