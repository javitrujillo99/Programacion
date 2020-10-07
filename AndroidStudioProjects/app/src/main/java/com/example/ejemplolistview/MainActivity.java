package com.example.ejemplolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        nombres = new ArrayList<String>();
        nombres.add("Seli");
        nombres.add("Javi");
        nombres.add("Moishi");
        nombres.add("Saritititi");

        //Un adaptador es la manera que hay de decir como queremos los datos en la lista
        //TODO: investigar los simples lists
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);

        //Le insertamos el adapter
        listView.setAdapter(adapter);

        //En este caso no vamos a usar setOnClickListener, sino con Item, porque queremos detectar UN ELEMENTO, no toda la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //position es la posicion en la lista que ocupa
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Pulsado: " + nombres.get(position), Toast.LENGTH_LONG).show();
            }
        });

        //Enlazamos el adaptador creado por mi con el MainActivity
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, nombres);
        listView.setAdapter(myAdapter);
    }
}
