package com.example.multimedia;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //Variables
    public static final int PETICION_FOTO = 1;
    public static final int PETICION_VIDEO = 2;
    public static final int PETICION_GALERIA_FOTOS = 3;
    public static final int PETICION_GALERIA_VIDEOS = 4;
    public static final int MEDIA_FOTO = 5;
    public static final int MEDIA_VIDEO = 6;
    private static final int REQUEST_CODE_FUNCTONE = 100;

    ImageView btnMusica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMusica = findViewById(R.id.botonReproductorMusica);
        pulsarBoton(btnMusica);
    }

    public void pulsarBoton(ImageView btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReproductorMusica.class);
                startActivityForResult(intent, REQUEST_CODE_FUNCTONE);
            }
        });
    }


    /**
     * Vamos a comprobar si la ejecucion de la captura de imagen se ha realizado correctamente
     * e insertamos la foto en la galería
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PETICION_GALERIA_FOTOS) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setData(data.getData());
            startActivity(intent);
        } else {
            Toast.makeText(this, "No se ha ejecutado la foto correctamente", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * ONCLICKS
     * @param view
     */



    //Esto es lo mismo que el setOnItemClickListener, coge el onClick ya del xml y se activa cuando se da click
    // a la view pasada en el método
    public void tomarFoto(View view) {
        /**Accedemos a la camara de fotos del dispositivo movil.
        Un intent es un mecanismo de software que permite a los usuarios coordinar las funciones
         de diferentes actividades para lograr una tarea.
         Dispone de 3 acciones que puede hacer:
         1. Lanzar un servicio, como por ejemplo la cámara
         2. Abrir una nueva Activity
         3. Hacer un broadcast  */

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, PETICION_FOTO);

    }

    public void tomarVideo(View view) {
        //Accedemos a la camara de video del dispositivo movil
    }

    public void galeriaFotos(View view) {
        //Aquí vamos a hacer que se abra la galería de fotos
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*"); //Así nos mostrará todos los tipos de imagenes (JPG, PNG, ETC)
        startActivityForResult(intent, PETICION_GALERIA_FOTOS);
    }

    public void galeriaVideos(View view) {
        //Aquí vamos a hacer que se guarde el vídeo que se ha hecho con la camara
    }


    /**
     * Creamos el archivo que vamos a guardar en galería despues de tomar foto o hacer video
     */
    //Uri es la traducción de Unify Results Identify, que es indicarle la carpeta donde vamos a guardar
    // las imagenes y el tipo de archivo de estas

    private Uri crearArchivo(int tipoMedio) throws IOException {
        //Guardaremos el nombre de cada foto que hagamos, le meteremos la fecha

        String fecha = new SimpleDateFormat("YYYYMMdd_HHmmss").format(new Date()); //Recogemos fecha
        String nombreArchivo;
        File archivo;

        if (tipoMedio == MEDIA_FOTO) { //Aquí creamos el archivo de la foto hecha
            nombreArchivo = "IMG_" + fecha;
            File directorioAlmacenamiento = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            archivo = File.createTempFile(nombreArchivo, "jpg", directorioAlmacenamiento);

            Log.d("TAG", archivo.getAbsolutePath());
            return Uri.fromFile(archivo);
        } else if (tipoMedio == MEDIA_VIDEO) { //Aquí creamos el archivo de video
            return null;
        } else {
            return null;
        }
    }

    /**
     * Vamos a ver como esta el almacenamiento de nuestro dispositivo, si tenemos espacio para guardar fotos
     */
    private boolean almacenamientoExternoDisponible() {
        String estado = Environment.getExternalStorageState();
        if (estado.equals(Environment.MEDIA_MOUNTED)) { //Esta montado nuestro almacenamiento
            return true;
        } else {
            return false;
        }
    }
}