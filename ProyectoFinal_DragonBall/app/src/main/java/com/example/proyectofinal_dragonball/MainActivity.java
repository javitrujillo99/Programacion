package com.example.proyectofinal_dragonball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declaramos todas las variables
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Insertamos el ListView en la activity
        listView = (ListView) findViewById(R.id.listView);
    }
}