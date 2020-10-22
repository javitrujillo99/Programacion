package com.example.practica4_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Intent explicito vs Intent implicito:
    // El Intent explicito pasa informacion de una Activity a otra, sabiendo ambas activites cuales van a ser
    // El intent implicito pasa informacion de una Activity a otra, SIN SABER la Activity de DESTINO

    //Variables
    EditText nombre;
    EditText edad;
    Button btn1;

    //Creamos el request code (El valor es lo de menos, puede ser cualquiera)
    private static final int REQUEST_CODE_FUNCTONE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.etNombre);
        edad = (EditText) findViewById(R.id.etEdad);
        btn1 = (Button) findViewById(R.id.btn1);
        pulsarBoton(btn1);
    }

    public void pulsarBoton(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent explicito, y le decimos que vaya desde aqui hasta la activity 2
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                //Insertamos los datos al intent
                intent.putExtra("nombre", nombre.getText().toString());
                intent.putExtra("edad", edad.getText().toString());

                //Lanzamos la activity (IMPORTANTE)
                startActivityForResult(intent, REQUEST_CODE_FUNCTONE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //Esto es por si hay algun error, nos dira donde esta el error
        if (requestCode == REQUEST_CODE_FUNCTONE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Lo has conseguido", Toast.LENGTH_SHORT).show();
            }
        }
    }
}