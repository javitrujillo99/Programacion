package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ToggleButton toggle;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enviarle una accion al boton
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //El .show() es importante para mostrarlo en pantalla
                Toast.makeText(MainActivity.this, "Seli es un PUTON", Toast.LENGTH_LONG).show();
            }
        });

        //ToogleButtons
        toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged (CompoundButton buttonView,boolean isChecked){
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_LONG).show();
                } else {
                    //CODIGO QUE QUERAMOS
                }
            }
        });
    }

    //Checkbox
    public void onCheckboxClicked(View miCheckbox) {
        boolean checked = ((CheckBox) miCheckbox).isChecked();
        switch (miCheckbox.getId()) {
            case R.id.checkbox_karate:
                if (checked) {
                    Toast.makeText(MainActivity.this, "KARATE", Toast.LENGTH_SHORT).show();
                }
            case R.id.checkbox_baloncesto:
                if (checked) {
                    Toast.makeText(MainActivity.this, "BALONCESTO", Toast.LENGTH_SHORT).show();
                }
        }
    }

    //RadioButtons
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_hombre:
                if (checked)
                    Toast.makeText(MainActivity.this, "HOMBRE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_mujer:
                if (checked)
                    Toast.makeText(MainActivity.this, "MUJER", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}