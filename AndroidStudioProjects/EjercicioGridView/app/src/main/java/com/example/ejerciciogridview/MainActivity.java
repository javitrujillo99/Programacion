package com.example.ejerciciogridview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declaramos todas las variables
    private GridView gridView;
    private List<Personaje> personajes;
    PersonajesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Insertamos el gridView en la activity
        gridView = (GridView) findViewById(R.id.gridView);

        //Creamos la lista de personajes que estarán en el gridView
        personajes = new ArrayList<Personaje>();
        llenarLista((ArrayList<Personaje>) personajes);

        //Inyectamos el Adapter en el main
        adapter = new PersonajesAdapter(this, R.layout.lista, personajes);
        gridView.setAdapter(adapter);

        //Cuando pulsemos en un personaje aparecerá el nombre
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, personajes.get(position).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        //Hacemos referencia al context menu para que lo muestre en pantalla
        registerForContextMenu(gridView);
    }

    /**
     * Método para llenar la lista
     * @param personajes
     */
    private void llenarLista(ArrayList<Personaje> personajes) {
        personajes.add(new Personaje("Goku","Son Gokū es el protagonista del manga y anime Dragon Ball creado por Akira Toriyama.",R.drawable.goku));
        personajes.add(new Personaje("Gohan","Son Gohan es un personaje del manga y anime Dragon Ball creado por Akira Toriyama. Es el primer hijo de Son Gokū y Chi-Chi",R.drawable.gohan));
        personajes.add(new Personaje("Goten","Goten es un personaje ficticio de la serie de manga y anime Dragon Ball. Segundo hijo del protagonista, Goku, y Chichi/Milk.",R.drawable.goten));
        personajes.add(new Personaje("Krilin","Krilin es un personaje de la serie de manga y anime Dragon Ball. Es el primer rival en artes marciales de Son Gokū aunque luego se convierte en su mejor amigo.",R.drawable.krilin));
        personajes.add(new Personaje("Piccolo","Piccolo es un personaje de ficción de la serie de manga y anime Dragon Ball. Su padre, Piccolo Daimaō, surgió tras separarse de Kamisama. ",R.drawable.piccolo));
        personajes.add(new Personaje("Trunks","Trunks es un personaje de ficción de la serie de manga y anime Dragon Ball de Akira Toriyama. Hijo de Vegueta y Bulma",R.drawable.trunks));
        personajes.add(new Personaje("Vegeta","Vegeta es un personaje ficticio perteneciente a la raza llamada saiyajin, del manga y anime Dragon Ball.",R.drawable.vegeta));
    }

    /**
     * MENU
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflamos menu
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Esto es para saber qué item está seleccionado en el menú. Lo mejor es hacer un switch
        switch (item.getItemId()) {
            case R.id.añadirPersonaje:
                personajes.add(new Personaje("Nombre", "Descripción", R.drawable.predeterminado));
                //Esto es para informar que se ha modificado la lista, tiene que ser en el adapter que está para esas cosas
                this.adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * CONTEXT MENU
     */

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Recogemos la información con el adapter. Sin esto no sale bien el menú.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        //Inflamos el context menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        //Recogemos la información con el adapter. Sin esto no sale bien el menú.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Personaje p = personajes.get(info.position);

        //Creamos el switch con todas las opciones del context menu
        switch (item.getItemId()) {
            case R.id.editar:

                //EL ALERT DIALOG NO VALE. UN ALERT ES SOLAMENTE PARA INFORMACION, Y ACEPTAR O CANCELAR.
                // SI QUEREMOS EDITAR EL PERSONAJE, TIENE QUE SER UN DIALOG FRAGMENT, NO ALERTDIALOG
                //Creamos un alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Editar personaje");
                builder.setMessage("Nombre: " + p.getNombre() + "\nDescripción: " + p.getDescripcion());
                builder.setPositiveButton("Aceptar", null);
                AlertDialog dialog = builder.create();
                dialog.show();
                this.adapter.notifyDataSetChanged(); //Esto es para notificar al adapter de los cambios
                return true;
            case R.id.borrar:
                this.personajes.remove(info.position);
                this.adapter.notifyDataSetChanged(); //Esto es para notificar al adapter de los cambios
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}

