package com.example.constraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnCancelar;
    private Button btnBorrar;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enviarle una accion al boton cancelar
        btnCancelar = (Button) findViewById(R.id.button4);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //El .show() es importante para mostrarlo en pantalla
                Toast.makeText(MainActivity.this, "Ha pulsado CANCELAR", Toast.LENGTH_LONG).show();
            }
        });

        //Enviarle una accion al boton borrar
        btnBorrar = (Button) findViewById(R.id.button5);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //El .show() es importante para mostrarlo en pantalla
                Toast.makeText(MainActivity.this, "Ha pulsado BORRAR TODO", Toast.LENGTH_LONG).show();
            }
        });

        //Enviarle una accion al boton enviar
        btnEnviar = (Button) findViewById(R.id.button6);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //El .show() es importante para mostrarlo en pantalla
                Toast.makeText(MainActivity.this, "Ha pulsado ENVIAR", Toast.LENGTH_LONG).show();
            }
        });
    }
}