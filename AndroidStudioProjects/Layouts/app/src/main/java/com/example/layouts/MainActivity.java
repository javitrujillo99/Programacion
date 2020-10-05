package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enviarle una accion al boton
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //El .show() es importante para mostrarlo en pantalla
                        Toast.makeText(MainActivity.this, "Seli es un PUTON", Toast.LENGTH_LONG).show();
                    }
                });
    }
}