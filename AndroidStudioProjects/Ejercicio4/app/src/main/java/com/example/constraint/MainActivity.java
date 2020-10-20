package com.example.constraint;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaro variables
    private Switch switchEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchEdad = findViewById(R.id.switchEdad);
    }

    /**
     * Con este método, ahorro código al usar el mismo método para los 3 botones
     * y así no hacer un setOnClickListener para cada botón. Es más eficiente.
     * Simplemente es una mejora para que detecte que los botones han sido pulsados.
     * @param view
     */

    //Necesaria una versión de la API de Android igual o superior a la 26
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void pulsarBoton(View view) {
        Toast.makeText(this, "Ha pulsado " +  view.getContentDescription(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Método para el switch. Simplemente he implementado mejoras para que detecte cuándo está activado
     * el switch y cuándo no.
     * @param view
     */
    public void pulsarSwitch(View view) {
        if (view.getId() == switchEdad.getId()) {
            if (switchEdad.isChecked()) { //Si está chequeado dirá que eres mayor de edad
                Toast.makeText(this, "Eres mayor de edad", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Eres menor de edad", Toast.LENGTH_SHORT).show();
            }
        }
    }
}