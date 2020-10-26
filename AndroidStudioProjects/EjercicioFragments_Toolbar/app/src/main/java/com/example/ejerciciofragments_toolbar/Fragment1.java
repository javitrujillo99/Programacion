package com.example.ejerciciofragments_toolbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment1 extends Fragment {

    EditText editText;
    Button btnEnviar;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Aquí guardamos los datos del editText

        editText = view.findViewById(R.id.editText);
        btnEnviar = view.findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("texto", editText.getText().toString());
                //PARA QUE SALGA GETPARENTFRAGMENTMANAGER TENEMOS QUE AÑADIR AL BUILD LAS DEPENDENCIAS
                // DEL FRAGMENT MANAGER Y SINCRONIZAR
                getParentFragmentManager().setFragmentResult("key", bundle);
            }
        });
    }
}