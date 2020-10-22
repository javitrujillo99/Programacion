package com.example.practica4_intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity2 extends Activity {

    //IMPORTANTE DECLARAR LA ACTIVITY CREADA EN EL ANDROIDMANIFEST

    //Variables
    String edad;
    String nombre;
    TextView textView2;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Declaramos la variable edad, que cogerá el valor del intent
        edad = getIntent().getStringExtra("edad");
        nombre = getIntent().getStringExtra("nombre");
        textView2 = (TextView) findViewById(R.id.textView2);

        textView2.setText("Tu nombre es " + nombre + " y tienes " + edad + " años");

        btn2 = (Button) findViewById(R.id.btn2);
        pulsarBoton(btn2);
    }

    public void pulsarBoton(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                //Esto es para que nos envie una respuesta si va bien
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
