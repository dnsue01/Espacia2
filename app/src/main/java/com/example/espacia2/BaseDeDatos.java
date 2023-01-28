package com.example.espacia2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDatos extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String NOMBRE="EspaciadosDB.db";
    private static final String TABLA_PREGUNTAS="Preguntas_Respuestas_Opciones";
    final String preguntas="PREGUNTAS";
    final String respuestas="RESPUESTAS";
    final String opciones="OPCIONES";
    final String tipo="TIPO";

    //categorias

    final String entretenimiento = "Entretenimiento";
    //falta ciencias
    final String deportes = "Ocio y deporte";

    final String historia = "Historia";

    //falta Arte y Literatura
    final  String geografia = "Geografía";



    //nombre de la tabla
    final String tablaDB= "Preguntas_Respuestas_Opciones";
    public BaseDeDatos(@Nullable Context context) {
        super(context, NOMBRE, null, DATABASE_VERSION);
    }
    public void  insertDB(){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values1 = new ContentValues();
        values1.put(preguntas, "¿Cuál es el río más largo del mundo?");
        values1.put(respuestas, "Nilo");
        values1.put(opciones, "Amazonas, Nilo, Yangtsé, Misisipi");

        values1.put(tipo, geografia);
        db.insert(tablaDB, null, values1);

        ContentValues values2 = new ContentValues();
        values2.put(preguntas, "¿En qué continente se encuentra Rusia?");
        values2.put(respuestas, "Europa y Asia");
        values2.put(opciones, "Europa y Asia, América del Norte, Oceanía,Antartica");
        values2.put(tipo, geografia);
        db.insert(tablaDB, null, values2);

        ContentValues values3 = new ContentValues();
        values3.put(preguntas, "¿Cuál es el país más grande del mundo?");
        values3.put(respuestas, "Rusia");
        values3.put(opciones, "Rusia, China, Estados Unidos, Canadá");
        values3.put(tipo, geografia);
        db.insert(tablaDB, null, values3);

        ContentValues values4 = new ContentValues();
        values4.put(preguntas, "¿Cuál es el desierto más grande del mundo?");
        values4.put(respuestas, "Sahara");
        values4.put(opciones, "Atacama, Sahara, Gobi, Kalahari");
        values4.put(tipo, geografia);
        db.insert(tablaDB, null, values4);

        ContentValues values5 = new ContentValues();
        values5.put(preguntas, "¿En qué océano se encuentra la Isla de Pascua?");
        values5.put(respuestas, "Pacífico");
        values5.put(opciones, "Pacífico, Atlántico, Índico, Antártico");
        values5.put(tipo, geografia);
        db.insert(tablaDB, null, values5);

        ContentValues values6 = new ContentValues();
        values6.put(preguntas, "¿Cuál es el lago más grande del mundo?");
        values6.put(respuestas, "Mar Caspio");
        values6.put(opciones, "Mar Caspio, Lago Superior, Lago Victoria,Lago Maria");
        values6.put(tipo, geografia);
        db.insert(tablaDB, null, values6);

        ContentValues values7 = new ContentValues();
        values7.put(preguntas, "¿En qué país se encuentra el río Amazonas?");
        values7.put(respuestas, "Todos");
        values7.put(opciones, "Todos, Colombia, Brasil, Ecuador");
        values7.put(tipo, geografia);
        db.insert(tablaDB, null, values7);

        ContentValues values8 = new ContentValues();
        values8.put(preguntas, "¿Cuál es la capital de España?");
        values8.put(respuestas, "Madrid");
        values8.put(opciones, "Barcelona, Madrid, Valencia,Londres");
        values8.put(tipo, geografia);
        db.insert(tablaDB, null, values8);

        ContentValues values10 = new ContentValues();
        values10.put(preguntas, "¿En qué país se encuentra la ciudad de Nueva York?");
        values10.put(respuestas, "Estados Unidos");
        values10.put(opciones, "Canadá, México, Estados Unidos,España");
        values10.put(tipo, geografia);
        db.insert(tablaDB, null, values10);

        ContentValues values11 = new ContentValues();
        values11.put(preguntas, "¿Cuál es la capital de Mexico?");
        values11.put(respuestas, "Ciudad de México");
        values11.put(opciones, "Ciudad de México, Guadalajara, Monterrey,Palencia");
        values11.put(tipo, geografia);
        db.insert(tablaDB, null, values11);

        ContentValues values12 = new ContentValues();
        values12.put(preguntas, "¿En qué país se encuentra la ciudad de Rio de Janeiro?");
        values12.put(respuestas, "Brasil");
        values12.put(opciones, "Brasil, Argentina, Chile,Bolivia");
        values12.put(tipo, geografia);
        db.insert(tablaDB, null, values12);

        ContentValues values13 = new ContentValues();
        values13.put(preguntas, "¿Cuál es la capital de Argentina?");
        values13.put(respuestas, "Buenos Aires");
        values13.put(opciones, "Buenos Aires, Mexico, Pompeya,Bogota");
        values13.put(tipo, geografia);
        db.insert(tablaDB, null, values13);

        ContentValues values14 = new ContentValues();
        values14.put(preguntas, "¿Cuál es el océano más grande del mundo?");
        values14.put(respuestas, "Océano Pacífico");
        values14.put(opciones, "Océano Pacífico, Océano Atlántico, Océano Índico,Océano Antartico");
        values14.put(tipo, geografia);
        db.insert(tablaDB, null, values14);

        ContentValues values15 = new ContentValues();
        values15.put(preguntas, "¿Cuál es la cadena montañosa más larga del mundo?");
        values15.put(respuestas, "Cordillera de los Andes");
        values15.put(opciones, "Cordillera de los Andes, Himalayas, Alpes,Everest");
        values15.put(tipo, geografia);
        db.insert(tablaDB, null, values15);

        ContentValues values16 = new ContentValues();
        values16.put(preguntas, "¿En qué país se encuentra el desierto del Sahara?");
        values16.put(respuestas, "África");
        values16.put(opciones, "África, Arabia, Australia,America");
        values16.put(tipo, geografia);
        db.insert(tablaDB, null, values16);

        ContentValues values17 = new ContentValues();
        values17.put(preguntas, "¿Cuál es el río más largo del mundo?");
        values17.put(respuestas, "Río Nilo");
        values17.put(opciones, "Río Nilo, Río Amazonas, Río Misisipi,Rio Esgueva");
        values17.put(tipo, geografia);
        db.insert(tablaDB, null, values17);

        ContentValues values18 = new ContentValues();
        values18.put(preguntas, "¿Cuál es el lago más grande del mundo?");
        values18.put(respuestas, "Lago Superior");
        values18.put(opciones, "Lago Superior, Lago Victoria, Lago Baikal, Lago Argentino");
        values18.put(tipo, geografia);
        db.insert(tablaDB, null, values18);

        ContentValues values19 = new ContentValues();
        values19.put(preguntas, "¿Cuál es la cadena montañosa más alta del mundo?");
        values19.put(respuestas, "Himalayas");
        values19.put(opciones, "Himalayas, Andes, Alpes,Everest");
        values19.put(tipo, geografia);
        db.insert(tablaDB, null, values19);

        ContentValues values20 = new ContentValues();
        values20.put(preguntas, "¿Cuál es el país con mayor superficie de desierto?");
        values20.put(respuestas, "Antártida");
        values20.put(opciones, "Antártida, Arabia, Australia,España");
        values20.put(tipo, geografia);
        db.insert(tablaDB, null, values20);


        ContentValues valuesDeporte1 = new ContentValues();
        valuesDeporte1.put(preguntas, "¿Cuál es el equipo con más títulos de la liga española de fútbol?");
        valuesDeporte1.put(respuestas, "Real Madrid");
        valuesDeporte1.put(opciones, "Real Madrid, FC Barcelona, Atlético Madrid,Porcinos fc");
        valuesDeporte1.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte1);

        ContentValues valuesDeporte2 = new ContentValues();
        valuesDeporte2.put(preguntas, "¿Cuál es el atleta con más medallas de oro en los Juegos Olímpicos?");
        valuesDeporte2.put(respuestas, "Michael Phelps");
        valuesDeporte2.put(opciones, "Michael Phelps, Usain Bolt, Carl Lewis,Daniel Nsue");
        valuesDeporte2.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte2);

        ContentValues valuesDeporte3 = new ContentValues();
        valuesDeporte3.put(preguntas, "¿Cuál es el equipo ganador del último mundial de futbol?");
        valuesDeporte3.put(respuestas, "Argentina");
        valuesDeporte3.put(opciones, "Francia, Croacia, Inglaterra, Argentina");
        valuesDeporte3.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte3);

        ContentValues valuesDeporte4 = new ContentValues();
        valuesDeporte4.put(preguntas, "¿Quién es el jugador de baloncesto más famoso de todos los tiempos?");
        valuesDeporte4.put(respuestas, "Michael Jordan");
        valuesDeporte4.put(opciones, "Michael Jordan, LeBron James, Kareem Abdul-Jabbar, Wilt Chamberlain");
        valuesDeporte4.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte4);

        ContentValues valuesDeporte5 = new ContentValues();
        valuesDeporte5.put(preguntas, "¿Cuál es el equipo de fútbol americano con más títulos de la NFL?");
        valuesDeporte5.put(respuestas, "Pittsburgh Steelers");
        valuesDeporte5.put(opciones, "Pittsburgh Steelers, Dallas Cowboys, San Francisco 49ers, New England Patriots");
        valuesDeporte5.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte5);

        ContentValues valuesDeporte6 = new ContentValues();
        valuesDeporte6.put(preguntas, "¿Cuál es el país con más medallas de oro en Juegos Olímpicos?");
        valuesDeporte6.put(respuestas, "Estados Unidos");
        valuesDeporte6.put(opciones, "Estados Unidos, Rusia, China, Alemania");
        valuesDeporte6.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte6);

        ContentValues valuesDeporte7 = new ContentValues();
        valuesDeporte7.put(preguntas, "¿Cuál es el equipo de béisbol con más títulos en las Grandes Ligas?");
        valuesDeporte7.put(respuestas, "New York Yankees");
        valuesDeporte7.put(opciones, "New York Yankees, St. Louis Cardinals, San Francisco Giants,Humaco");
        valuesDeporte7.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte7);

        ContentValues valuesDeporte10 = new ContentValues();
        valuesDeporte10.put(preguntas, "¿Cuál es el equipo de futbol con más títulos de la UEFA Champions League?");
        valuesDeporte10.put(respuestas, "Real Madrid");
        valuesDeporte10.put(opciones, "Real Madrid, FC Barcelona, Manchester United,Rayo Vallecano ");
        valuesDeporte10.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte10);

        ContentValues valuesDeporte11 = new ContentValues();
        valuesDeporte11.put(preguntas, "¿Cuál es el país con más títulos en la Copa del Mundo FIFA?");
        valuesDeporte11.put(respuestas, "Brasil");
        valuesDeporte11.put(opciones, "Brasil, Alemania, Italia , Argentina");
        valuesDeporte11.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte11);

        ContentValues valuesDeporte12 = new ContentValues();
        valuesDeporte12.put(preguntas, "¿Quién es el Jugador de la NBA con más MVP?");
        valuesDeporte12.put(respuestas, "Kareem Abdul-Jabbar");
        valuesDeporte12.put(opciones, "Kareem Abdul-Jabbar, Michael Jordan, LeBron James,Jhonny Sins");
        valuesDeporte12.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte12);

        ContentValues valuesDeporte13 = new ContentValues();
        valuesDeporte13.put(preguntas, "¿Cuál es el equipo de Fórmula 1 con más títulos de Constructores?");
        valuesDeporte13.put(respuestas, "Ferrari");
        valuesDeporte13.put(opciones, "Ferrari, Mercedes, Red Bull Racing,Audi ");
        valuesDeporte13.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte13);

        ContentValues valuesDeporte14 = new ContentValues();
        valuesDeporte14.put(preguntas, "¿Cuál es el mejor jugador de Tenis de todos los tiempos?");
        valuesDeporte14.put(respuestas, "Roger Federer");
        valuesDeporte14.put(opciones, "Roger Federer, Rafael Nadal, Novak Djokovic ,Selena Wiliams");
        valuesDeporte14.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte14);

        ContentValues valuesDeporte15 = new ContentValues();
        valuesDeporte15.put(preguntas, "¿Cuál es el equipo de Rugby con más títulos de la Copa del Mundo?");
        valuesDeporte15.put(respuestas, "Nueva Zelanda");
        valuesDeporte15.put(opciones, "Nueva Zelanda, Sudáfrica, Australia ,Inglaterra");
        valuesDeporte15.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte15);

        ContentValues valuesDeporte16 = new ContentValues();
        valuesDeporte16.put(preguntas, "¿Cuál es el equipo de Football americano con más Super Bowls ganadas?");
        valuesDeporte16.put(respuestas, "Pittsburgh Steelers");
        valuesDeporte16.put(opciones, "Pittsburgh Steelers, San Francisco 49ers, New England Patriots ,New york yankes");
        valuesDeporte16.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte16);

        ContentValues valuesDeporte17 = new ContentValues();
        valuesDeporte17.put(preguntas, "¿Cuál es el país con más medallas de oro en Juegos Panamericanos?");
        valuesDeporte17.put(respuestas, "Estados Unidos");
        valuesDeporte17.put(opciones, "Estados Unidos, Brasil, Cuba,Canada ");
        valuesDeporte17.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte17);

        ContentValues valuesDeporte18 = new ContentValues();
        valuesDeporte18.put(preguntas, "¿Cuál es el equipo de Voleyball con más títulos en el Mundial?");
        valuesDeporte18.put(respuestas, "Rusia");
        valuesDeporte18.put(opciones, "Rusia, Brasil, Italia,España ");
        valuesDeporte18.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte18);

        ContentValues valuesDeporte19 = new ContentValues();
        valuesDeporte19.put(preguntas, "¿Cuál es el país con más medallas de oro en Juegos Paralímpicos?");
        valuesDeporte19.put(respuestas, "Estados Unidos");
        valuesDeporte19.put(opciones, "Estados Unidos, China, Reino Unido ,Gales");
        valuesDeporte19.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte19);

        ContentValues valuesDeporte20 = new ContentValues();
        valuesDeporte20.put(preguntas, "¿Cuál es el equipo de Basquetbol con más títulos en la NBA?");
        valuesDeporte20.put(respuestas, "Boston Celtics");
        valuesDeporte20.put(opciones, "Boston Celtics, Los Angeles Lakers, Chicago Bulls ,Bulls");
        valuesDeporte20.put(tipo, deportes);
        db.insert(tablaDB, null, valuesDeporte20);

        ContentValues valuesHistoria1 = new ContentValues();
        valuesHistoria1.put(preguntas, "¿Quién fue el primer emperador romano?");
        valuesHistoria1.put(respuestas, "Augusto");
        valuesHistoria1.put(opciones, "Augusto, Julio César, Nerón,Cleopatera");

        valuesHistoria1.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria1);

        ContentValues valuesHistoria2 = new ContentValues();
        valuesHistoria2.put(preguntas, "¿Cuál fue la causa principal de la Primera Guerra Mundial?");
        valuesHistoria2.put(respuestas, "El asesinato de Francisco Fernando");
        valuesHistoria2.put(opciones, "El asesinato de Francisco Fernando, la competencia colonial, potencias europeas,Un romance");
        valuesHistoria2.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria2);

        ContentValues valuesHistoria3 = new ContentValues();
        valuesHistoria3.put(preguntas, "¿Quién fue el líder del partido Nazi en Alemania?");
        valuesHistoria3.put(respuestas, "Adolf Hitler");
        valuesHistoria3.put(opciones, "Adolf Hitler, Joseph Goebbels, Hermann Göring,Muller");
        valuesHistoria3.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria3);

        ContentValues valuesHistoria4 = new ContentValues();
        valuesHistoria4.put(preguntas, "¿Quién fue el primer presidente de Estados Unidos?");
        valuesHistoria4.put(respuestas, "George Washington");
        valuesHistoria4.put(opciones, "George Washington, John Adams, Thomas Jefferson,Obama ");
        valuesHistoria4.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria4);

        ContentValues valuesHistoria5 = new ContentValues();
        valuesHistoria5.put(preguntas, "¿Qué evento desencadenó la Revolución Francesa?");
        valuesHistoria5.put(respuestas, "La crisis económica y financiera del reino");
        valuesHistoria5.put(opciones, "La crisis económica y financiera del reino, el malestar social, el descontento con la monarquía,Un pastido de futbol");
        valuesHistoria5.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria5);

        ContentValues valuesHistoria6 = new ContentValues();
        valuesHistoria6.put(preguntas, "¿Quién fue el primer rey de Inglaterra?");
        valuesHistoria6.put(respuestas, "Alfredo el Grande");
        valuesHistoria6.put(opciones, "Alfredo el Grande, Guillermo el Conquistador, Enrique VIII,Isabel II");
        valuesHistoria6.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria6);

        ContentValues valuesHistoria7 = new ContentValues();
        valuesHistoria7.put(preguntas, "¿Quién fue el líder del régimen soviético durante la Segunda Guerra Mundial?");
        valuesHistoria7.put(respuestas, "Joseph Stalin");
        valuesHistoria7.put(opciones, "Joseph Stalin, Leon Trotsky, Nikita Khrushchev,Hitler");
        valuesHistoria7.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria7);

        ContentValues valuesHistoria8 = new ContentValues();
        valuesHistoria8.put(preguntas, "¿Quién fue el líder del movimiento de independencia de India?");
        valuesHistoria8.put(respuestas, "Mahatma Gandhi");
        valuesHistoria8.put(opciones, "Mahatma Gandhi, Jawaharlal Nehru, Sardar Patel,Buda");
        valuesHistoria8.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria8);

        ContentValues valuesHistoria9 = new ContentValues();
        valuesHistoria9.put(preguntas, "¿Qué evento desencadenó la Segunda Guerra Mundial?");
        valuesHistoria9.put(respuestas, "El ataque de Alemania a Polonia");
        valuesHistoria9.put(opciones, "El ataque de Alemania a Polonia, Pacto  Alemania y la Unión Soviética, la invasión de Japón a China,Bombas a Japón");
        valuesHistoria9.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria9);

        ContentValues valuesHistoria10 = new ContentValues();
        valuesHistoria10.put(preguntas, "¿Quién fue el fundador del Imperio Romano?");
        valuesHistoria10.put(respuestas, "Romulo");
        valuesHistoria10.put(opciones, "Romulo, Julio César, Nerón;León");
        valuesHistoria10.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria10);

        ContentValues valuesHistoria11 = new ContentValues();
        valuesHistoria11.put(preguntas, "¿Qué evento desencadenó la Primera Guerra Mundial?");
        valuesHistoria11.put(respuestas, "El asesinato del archiduque austriaco Francisco Fernando");
        valuesHistoria11.put(opciones, "El asesinato del archiduque austriaco Francisco Fernando, la competencia colonial, la rivalidad entre las potencias europeas,Una relación");
        valuesHistoria11.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria11);

        ContentValues valuesHistoria12 = new ContentValues();
        valuesHistoria12.put(preguntas, "¿Quién fue el líder de la Revolución Rusa?");
        valuesHistoria12.put(respuestas, "Vladimir Lenin");
        valuesHistoria12.put(opciones, "Vladimir Lenin, Joseph Stalin, Leon Trotsky,Hitler");
        valuesHistoria12.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria12);

        ContentValues valuesHistoria13 = new ContentValues();
        valuesHistoria13.put(preguntas, "¿Quién fue el primer presidente de la República Francesa?");
        valuesHistoria13.put(respuestas, "Napoleón Bonaparte");
        valuesHistoria13.put(opciones, "Napoleón Bonaparte, Louis XVIII, Charles X,Mbappe");
        valuesHistoria13.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria13);

        ContentValues valuesHistoria14 = new ContentValues();
        valuesHistoria14.put(preguntas, "¿Quién fue el líder del Movimiento por la independencia de Estados Unidos?");
        valuesHistoria14.put(respuestas, "George Washington");
        valuesHistoria14.put(opciones, "George Washington, Thomas Jefferson, John Adams,Django");
        valuesHistoria14.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria14);

        ContentValues valuesHistoria15 = new ContentValues();
        valuesHistoria15.put(preguntas, "¿Quién fue el líder de la Revolución China?");
        valuesHistoria15.put(respuestas, "Mao Zedong");
        valuesHistoria15.put(opciones, "Mao Zedong, Sun Yat-sen, Chiang Kai-shek,Jacky chan");
        valuesHistoria15.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria15);

        ContentValues valuesHistoria16 = new ContentValues();
        valuesHistoria16.put(preguntas, "¿Quién fue el líder del movimiento por la independencia de Egipto?");
        valuesHistoria16.put(respuestas, "Gamal Abdel Nasser");
        valuesHistoria16.put(opciones, "Gamal Abdel Nasser, Anwar Sadat, Hosni Mubarak,Cleopatra");
        valuesHistoria16.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria16);

        ContentValues valuesHistoria17 = new ContentValues();
        valuesHistoria17.put(preguntas, "¿Quién fue el líder del movimiento por la independencia de India?");
        valuesHistoria17.put(respuestas, "Mahatma Gandhi");
        valuesHistoria17.put(opciones, "Mahatma Gandhi, Jawaharlal Nehru, Sardar Patel,Picolo");
        valuesHistoria17.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria17);
        ContentValues valuesHistoria18 = new ContentValues();
        valuesHistoria18.put(preguntas, "¿Qué evento desencadenó la Revolución Industrial?");
        valuesHistoria18.put(respuestas, "El desarrollo de la máquina de vapor");
        valuesHistoria18.put(opciones, "El desarrollo de la máquina de vapor, el surgimiento de nuevas tecnologías, el aumento de la población urbana,telefonos");
        valuesHistoria18.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria18);

        ContentValues valuesHistoria19 = new ContentValues();
        valuesHistoria19.put(preguntas, "¿Quién fue el líder del Movimiento por la independencia de México?");
        valuesHistoria19.put(respuestas, "Miguel Hidalgo y Costilla");
        valuesHistoria19.put(opciones, "Miguel Hidalgo y Costilla, José María Morelos, Vicente Guerrero,Luisito comunica");
        valuesHistoria19.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria19);

        ContentValues valuesHistoria20 = new ContentValues();
        valuesHistoria20.put(preguntas, "¿Qué evento desencadenó la Revolución Rusa?");
        valuesHistoria20.put(respuestas, "La Primera Guerra Mundial y la crisis económica");
        valuesHistoria20.put(opciones, "La Primera Guerra Mundial y la crisis económica, el malestar social, el descontento con el régimen zarista,el frio");
        valuesHistoria20.put(tipo, historia);
        db.insert(tablaDB, null, valuesHistoria20);

        ContentValues valuesEntretenimiento1 = new ContentValues();
        valuesEntretenimiento1.put(preguntas, "¿Quién es el creador de Harry Potter?");
        valuesEntretenimiento1.put(respuestas, "J.K. Rowling");
        valuesEntretenimiento1.put(opciones, "J.K. Rowling, Stephen King, George R.R. Martin,Pepita");
        valuesEntretenimiento1.put(tipo, entretenimiento);

        db.insert(tablaDB, null, valuesEntretenimiento1);

        ContentValues valuesEntretenimiento2 = new ContentValues();
        valuesEntretenimiento2.put(preguntas, "¿Quién es el actor que interpreta a Iron Man?");
        valuesEntretenimiento2.put(respuestas, "Robert Downey Jr.");
        valuesEntretenimiento2.put(opciones, "Robert Downey Jr., Chris Evans, Chris Hemsworth,Lebron James");
        valuesEntretenimiento2.put(tipo, entretenimiento);

        db.insert(tablaDB, null, valuesEntretenimiento2);

        ContentValues valuesEntretenimiento3 = new ContentValues();
        valuesEntretenimiento3.put(preguntas, "¿Quién es el director de la saga de películas de Harry Potter?");
        valuesEntretenimiento3.put(respuestas, "David Yates");
        valuesEntretenimiento3.put(opciones, "David Yates, Chris Columbus, Alfonso Cuarón,JK rolling");
        valuesEntretenimiento3.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento3);

        ContentValues valuesEntretenimiento4 = new ContentValues();
        valuesEntretenimiento4.put(preguntas, "¿Quién es el actor que interpreta a Sherlock Holmes en la serie de televisión?");
        valuesEntretenimiento4.put(respuestas, "Benedict Cumberbatch");
        valuesEntretenimiento4.put(opciones, "Benedict Cumberbatch, Robert Downey Jr., Jonny Lee Miller,Holes Shelock");
        valuesEntretenimiento4.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento4);

        ContentValues valuesEntretenimiento5 = new ContentValues();
        valuesEntretenimiento5.put(preguntas, "¿Quién es el director de la saga de películas de Star Wars?");
        valuesEntretenimiento5.put(respuestas, "J.J. Abrams");
        valuesEntretenimiento5.put(opciones, "J.J. Abrams, George Lucas, Rian Johnson,Yoda");
        valuesEntretenimiento5.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento5);

        ContentValues valuesEntretenimiento6 = new ContentValues();
        valuesEntretenimiento6.put(preguntas, "¿Quién es el actor que interpreta a James Bond?");
        valuesEntretenimiento6.put(respuestas, "Daniel Craig");
        valuesEntretenimiento6.put(opciones, "Daniel Craig, Sean Connery, Roger Moore,Jorge king");
        valuesEntretenimiento6.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento6);

        ContentValues valuesEntretenimiento7 = new ContentValues();
        valuesEntretenimiento7.put(preguntas, "¿Quién es el creador de la serie de televisión Game of Thrones?");
        valuesEntretenimiento7.put(respuestas, "George R.R. Martin");
        valuesEntretenimiento7.put(opciones, "George R.R. Martin, J.K. Rowling, Stephen King,Will smith");
        valuesEntretenimiento7.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento7);

        ContentValues valuesEntretenimiento8 = new ContentValues();
        valuesEntretenimiento8.put(preguntas, "¿Quién es el director de la saga de películas de El Señor de los Anillos?");
        valuesEntretenimiento8.put(respuestas, "Peter Jackson");
        valuesEntretenimiento8.put(opciones, "Peter Jackson, George Lucas, J.R.R. Tolkien,Golum");
        valuesEntretenimiento8.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento8);

        ContentValues valuesEntretenimiento9 = new ContentValues();
        valuesEntretenimiento9.put(preguntas, "¿Quién es el creador de la serie de televisión The Walking Dead?");
        valuesEntretenimiento9.put(respuestas, "Frank Darabont");
        valuesEntretenimiento9.put(opciones, "Frank Darabont, Robert Kirkman, Greg Nicotero,Kasandra");
        valuesEntretenimiento9.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento9);
        ContentValues valuesEntretenimiento10 = new ContentValues();
        valuesEntretenimiento10.put(preguntas, "¿Quién es el creador de la serie de televisión Breaking Bad?");
        valuesEntretenimiento10.put(respuestas, "Vince Gilligan");
        valuesEntretenimiento10.put(opciones, "Vince Gilligan, Peter Gould, Mark Johnson,Rick sanchez");
        valuesEntretenimiento10.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento10);

        ContentValues valuesEntretenimiento11 = new ContentValues();
        valuesEntretenimiento11.put(preguntas, "¿Quién es el actor que interpreta a Batman en la serie de películas de Christopher Nolan?");
        valuesEntretenimiento11.put(respuestas, "Christian Bale");
        valuesEntretenimiento11.put(opciones, "Christian Bale, Michael Keaton, Val Kilmer,Bruce wayne");
        valuesEntretenimiento11.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento11);

        ContentValues valuesEntretenimiento12 = new ContentValues();
        valuesEntretenimiento12.put(preguntas, "¿Quién es el creador de la serie de televisión The Big Bang Theory?");
        valuesEntretenimiento12.put(respuestas, "Chuck Lorre");
        valuesEntretenimiento12.put(opciones, "Chuck Lorre, Bill Prady, Steven Molaro,Sheldon");
        valuesEntretenimiento12.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento12);

        ContentValues valuesEntretenimiento13 = new ContentValues();
        valuesEntretenimiento13.put(preguntas, "¿Quién es el creador de la serie de televisión Friends?");
        valuesEntretenimiento13.put(respuestas, "David Crane y Marta Kauffman");
        valuesEntretenimiento13.put(opciones, "David Crane y Marta Kauffman, Kevin S. Bright y Marta Kauffman, David Crane y Kevin S. Bright,Lamelo ball y su padre ");
        valuesEntretenimiento13.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento13);
        ContentValues valuesEntretenimiento14 = new ContentValues();
        valuesEntretenimiento14.put(preguntas, "¿Quién es el creador de la serie de televisión The Office?");
        valuesEntretenimiento14.put(respuestas, "Ricky Gervais y Stephen Merchant");
        valuesEntretenimiento14.put(opciones, "Ricky Gervais y Stephen Merchant, Greg Daniels, Ben Silverman,Jhonny Sins");
        valuesEntretenimiento14.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento14);

        ContentValues valuesEntretenimiento15 = new ContentValues();
        valuesEntretenimiento15.put(preguntas, "¿Quién es el creador de la serie de televisión The Sopranos?");
        valuesEntretenimiento15.put(respuestas, "David Chase");
        valuesEntretenimiento15.put(opciones, "David Chase, Matthew Weiner, Terence Winter,Jons ");
        valuesEntretenimiento15.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento15);

        ContentValues valuesEntretenimiento16 = new ContentValues();
        valuesEntretenimiento16.put(preguntas, "¿Quién es el creador de la serie de televisión The Wire?");
        valuesEntretenimiento16.put(respuestas, "David Simon");
        valuesEntretenimiento16.put(opciones, "David Simon, George Pelecanos, Ed Burns,Maria Magdalena ");
        valuesEntretenimiento16.put(tipo, entretenimiento);
        db.insert(tablaDB, null, valuesEntretenimiento16);






    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_PREGUNTAS + "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PREGUNTAS text not null,"+
                "RESPUESTAS TEXT not null,"+
                "TIPO Text not null,"+
                "OPCIONES TEXT not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        onCreate(sqLiteDatabase);
    }
}
