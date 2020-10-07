package com.example.ejemplolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Creamos nuestro propio Adapter (importante que extienda de BaseAdapter)
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> nombres;

    /**
     * Constructor
     */
    public MyAdapter(Context context, int layout, List<String> nombres) {
        //IMPORTANTE: El context es la Activity, el layout es el .xml que creamos
        this.context = context;
        this.layout = layout;
        this.nombres = nombres;
    }

    @Override
    public int getCount() {
        return this.nombres.size(); //Que nos devuelva el tamaño de la lista
    }

    @Override
    public Object getItem(int position) {
        return this.nombres.get(position); //Que nos devuelva el nombre en esa posicion
    }

    @Override
    public long getItemId(int id) {
        return id; //Que nos devuelva el id
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Esto lo que hace es coger cada elemento de la lista y crearle un textview para cada una con el nombre del elemento

        View v = convertView;

        //Esto es inflar la vista
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        //La inflamos con el layout creado por nosotros (list_item)
        v = layoutInflater.inflate(R.layout.list_item, null);

        //Recogemos el valor del dato actual segun la posicion
        String currentName = nombres.get(position);

        //Aqui recogemos el textview que puse en el layout personalizado con el nombre
        TextView textView = (TextView) v.findViewById(R.id.textView);

        //Asignamos el string al textView
        textView.setText(currentName);

        return v;
    }
}
