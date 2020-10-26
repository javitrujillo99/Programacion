package com.example.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_pink.*


class PinkFragment : Fragment() {

    private var listener: OnFragmentActionListener? = null

    override fun onAttach(context: Context) {
        //onAttach es lo primero que se ejecuta, es lo que sucede al crearse el fragment
        super.onAttach(context)
        //Comprobamos que si el contexto es de tipo OnFragmentActionListener, le añadimos el
        // contexto al listener y asi el listener sera el contexto y no null
        if (context is OnFragmentActionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        //onDetach es lo ultimo que sucede antes de destruir el fragment
        super.onDetach()
        //Ponemos el listener a null para que no ocupe espacio en la memoria antes de destruir el fragment
        listener = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        //OnCreateView es para crear la vista
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pink, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //OnViewCreated es una vez la vista esta creada
        super.onViewCreated(view, savedInstanceState)
        //Llamamos al boton creado y le hacemos un setOnClickListener
        btnPlus.setOnClickListener {
            //Llamamos la funcion de ejecutar el boton
            listener?.OnClickFragmentButton()
        }
    }


}