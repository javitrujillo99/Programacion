package com.example.ejemplosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Base de datos
    private SQLiteDatabase db;

    //Helper
    private AlmacenSQL almacen;

    //Indice para insertar los elementos
    private int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos nuestra base de datos
        almacen = new AlmacenSQL(this, "BaseDatos", null, 1);

        //inicializamos el indice de las inserciones
        indice = obtenerUltimoIndice();

        // funcion de consulta a la BBDD
        consultarBD();

        //Obtenemos acceso al campo de texto del usuario
        final EditText consulta = (EditText) findViewById(R.id.textoEntrada);

        // Vamos a implementar la funcionalidad de los botones
        Button insertar = (Button) findViewById(R.id.btnInsertar);
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mostramos un toast
                CharSequence text = "Se ha pulsado insertar";

                //Duracion del Toast
                int duration = Toast.LENGTH_LONG;

                //Dialogo del toast
                Toast toast = Toast.makeText(MainActivity.this, text, duration);

                //Mostramos el pop-up con mensaje
                toast.show();

                //Insertacion
                String nombreProducto = consulta.getText().toString();
                insertarProducto(nombreProducto);
                consultarBD();
                consulta.setText("");
            }
        });

        //Borrado
        Button borrar = (Button) findViewById(R.id.btnBorrar);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mostramos un toast
                CharSequence text = "Se ha pulsado borrar";

                //Duracion del Toast
                int duration = Toast.LENGTH_LONG;

                //Dialogo del toast
                Toast toast = Toast.makeText(MainActivity.this, text, duration);

                //Mostramos el pop-up con mensaje
                toast.show();

                //Borrado
                String nombreProducto = consulta.getText().toString();
                borrarProducto(nombreProducto);
                consultarBD();
                consulta.setText("");
            }
        });
    }

    public void insertarProducto(String nombreProducto) {
        String sentenciaCreacion = "INSERT INTO almacen (id, nombre) VALUES (" + indice + ", '" + nombreProducto + "');";
        // Comprobamos que se introduce un nombre
        if (!nombreProducto.equals("")) {
            // acceso a la BBDD con permisos de escritura y ejecutamos
            db = almacen.getWritableDatabase();
            db.execSQL(sentenciaCreacion);
            // Cerramos la conexión
            db.close();
            indice++;
        }
    }

    public void borrarProducto(String nombreProducto) {

        //Sentencia de borrado
        String sentenciaBorrado = "DELETE FROM almacen WHERE (nombre='" + nombreProducto + "');";

        //Pedimos acceso y ejecutamos la consulta
        db = almacen.getWritableDatabase();
        db.execSQL(sentenciaBorrado);

        // Cerramos la conexión
        db.close();
    }

    public ArrayList<ArrayList<String>> getListadoCompletoAlmacen() {

        //Pedimos acceso con permisos de lectura y escritura
        db = almacen.getWritableDatabase();

        //Definimos los campos que queremos consultar en la tabla
        String[] CAMPOS = {"id", "nombre"};

        //Definimos un array para almacenar los resultados
        ArrayList<ArrayList<String>> resultadoConsulta = new ArrayList<ArrayList<String>>();

        //El cursor
        Cursor cursor = db.query("almacen", CAMPOS, null, null, null, null, null, null);
        //Mientras existan resultados seguiremos recorriendo los resultados de la consulta

        int i = 0;
        if (cursor.getCount() > 0)
            while (cursor.moveToNext()) {

                //Se inicia el array temporal
                ArrayList<String> temp = new ArrayList<String>();

                //Añadimos los resultados al array temporal
                temp.add(cursor.getString(0));
                temp.add(cursor.getString(1));

                //cargamos el array principal con el resultado acual
                resultadoConsulta.add(temp);
            }

        // Cerramos la conexión
        db.close();

        // Se devuleven los resultados
        return resultadoConsulta;
    }

    public int obtenerUltimoIndice() {
        db = almacen.getWritableDatabase();
        String[] CAMPOS = {"id", "nombre"};
        int indiceDevuelto = -1;
        Cursor cursor = db.query("almacen", null, "id=(SELECT id FROM " +
                "almacen ORDER BY id DESC LIMIT 1)", null, null, null, null);
        int i = 0;
        if (cursor.getCount() > 0)
            while (cursor.moveToNext()) {
                indiceDevuelto = cursor.getInt(0);
            }
        db.close();

        // Mostramos un toast para conocer el ultimo indice
        CharSequence text = "El ultimo indice es: " + indiceDevuelto;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();

        // Devolvemos los resultados
        return indiceDevuelto + 1;
    }

    public void consultarBD() {
        db = almacen.getWritableDatabase();

        //rellenamos el cuadro de texto con el contenido de la tabla
        EditText multiline = (EditText) findViewById(R.id.cuadroSalidas);

        //Deshabilitamos el edittext para que el usuario no sea capaz de modificar el texto
        multiline.setFocusable(false);

        //creamos una variable temporal
        ArrayList<ArrayList<String>> resultados = new ArrayList<ArrayList<String>>();
        resultados = getListadoCompletoAlmacen();

        //se borra lo que este escrito para tener los datos actualizados
        multiline.setText("");
        for (int i = 0; i < resultados.size(); i++) {
            multiline.append("id: " + resultados.get(i).get(0) + ", nombre: " +
                    resultados.get(i).get(1) + "\n");
        }

        //cerramos la conexion con la base de datos
        db.close();
    }
}