package com.example.ejemplosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class AlmacenSQL extends SQLiteOpenHelper {

    //Creamos una copia a la referencia a la base de datos para poder
    //acceder a ella desde métodos que normalmente no lo permitirían,
    //como métodos existentes que no sobrescriben SQLiteOpenHelper.
    private SQLiteDatabase db;
    //Guardamos el context
    Context contexto;

    //Constructor
    public AlmacenSQL(Context context, String nombre, SQLiteDatabase.CursorFactory
            factory, int version) {
        super(context, nombre, factory, version);
        contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //definimos la sentencia de creación de una tabla
        String sentenciaCreacion = "CREATE TABLE almacen (id INTEGRER, nombre TEXT);";

        //Ejecutamos la sentencia
        db.execSQL(sentenciaCreacion);

        //copiamos la referencia
        this.db = db;

        //Ahora vamos a mostrar un toast que nos indique cuando se cree
        CharSequence text = "Se ha creado la base de datos";

        //duración del toast
        int duration = Toast.LENGTH_LONG;

        //Creamos el dialogo
        Toast toast = Toast.makeText(contexto, text, duration);

        //mostramos el toast
        toast.show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // El proceso normal cuando actualizamos la base de datos es crear una nueva usando
        // los datos de la anterior, para este ejemplo borraremos la anterior.
        String sentenciaDestruccion = "DROP TABLE IF EXISTS almacen";

        //Ejecutamos la sentencia
        db.execSQL(sentenciaDestruccion);
    }


}
