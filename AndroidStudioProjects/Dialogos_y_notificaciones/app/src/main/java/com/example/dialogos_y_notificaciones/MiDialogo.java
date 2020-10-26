package com.example.dialogos_y_notificaciones;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MiDialogo extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //Usamos la clase Builder para facilitar la construcicon del Dialog
        //Obtenemos la Activity en la que se crea con getActivity
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        /*En caso de que queramos añadirle un layout personalizado:
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.nombre_layout, null));
        */

        builder.setTitle("Eliminar")
                .setMessage("Estás seguro de que desea eliminar?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Acción a realizar al pulsar aceptar
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Acción a realizar al pulsar cancelar
                    }
                });

        //Creo el AlertDialog
        AlertDialog alertDialog = builder.create();
        return alertDialog;

    }
}
