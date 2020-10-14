package com.example.ejemplolistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private int contador = 0;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creo el listView en el XML y lo declaro aqui
        listView = (ListView) findViewById(R.id.listView);

        //Creo una lista para añadirla al listview
        nombres = new ArrayList<String>();
        nombres.add("Mantenme pulsado");
        nombres.add("Seli");
        nombres.add("Javi");

        /** Un adaptador es la manera que hay de decir como queremos los datos en la lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);

        //Le insertamos el adapter
        listView.setAdapter(adapter);

         **/

        //En este caso no vamos a usar setOnClickListener, sino con Item, porque queremos detectar UN ELEMENTO, no toda la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //position es la posicion en la lista que ocupa
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Pulsado: " + nombres.get(position), Toast.LENGTH_LONG).show();
            }
        });

        //Enlazamos el adaptador creado por mi con el MainActivity
        myAdapter = new MyAdapter(this, R.layout.list_item, nombres);
        listView.setAdapter(myAdapter);

        //Hacemos referencia al context menu para que lo muestre en pantalla
        registerForContextMenu(listView);
    }

    /**
     * MENU
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflamos el menú para que lo muestre

        MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.action_bar_menu, menu);
            return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Esto es para saber qué item está seleccionado en el menú. Lo mejor es hacer un switch
        switch (item.getItemId()) {
            case R.id.añadirElemento:
                this.nombres.add("Añadido nº " + (++contador)); //Añadimos el elemento a la lista creada de nombres

                //Esto es para informar que se ha modificado la lista, tiene que ser en el adapter que está para esas cosas
                this.myAdapter.notifyDataSetChanged();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * CONTEXT MENU (APARECE EN UNA PULSACION LARGA SOBRE UN ITEM (MANTENER PULSADO))
     */

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Recogemos la información con el adapter. Sin esto no sale bien el menú.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        //Inflamos el menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //Esto es para recoger la información del item seleccionado, obviamente la informacion esta en el adaptador.
        //MUY IMPORTANTE EN CONTEXTMENU!!!
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        //Esto es para saber qué item está seleccionado en el menú. Lo mejor es hacer un switch
        switch (item.getItemId()) {

            case R.id.borrarElemento:
                this.nombres.remove(info.position);
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
