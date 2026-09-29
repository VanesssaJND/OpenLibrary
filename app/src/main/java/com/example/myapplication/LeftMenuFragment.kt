package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class LeftMenuFragment : Fragment(R.layout.fragment_left_menu) {

    private var listener: OnMenuOptionSelectedListener? = null

    private lateinit var btnPerfil: Button
    private lateinit var btnFotos: Button
    private lateinit var btnVideo: Button
    private lateinit var btnWeb: Button
    private lateinit var btnBotones: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMenuOptionSelectedListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar OnMenuOptionSelectedListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPerfil = view.findViewById(R.id.btnPerfil)
        btnFotos = view.findViewById(R.id.btnFotos)
        btnVideo = view.findViewById(R.id.btnVideo)
        btnWeb = view.findViewById(R.id.btnWeb)
        btnBotones = view.findViewById(R.id.btnBotones)

        // Seleccionar perfil por defecto al cargar el menú
        updateSelectedState(btnPerfil)

        btnPerfil.setOnClickListener {
            updateSelectedState(btnPerfil)
            listener?.onOptionSelected("PERFIL")
        }

        btnFotos.setOnClickListener {
            updateSelectedState(btnFotos)
            listener?.onOptionSelected("FOTOS")
        }

        btnVideo.setOnClickListener {
            updateSelectedState(btnVideo)
            listener?.onOptionSelected("VIDEO")
        }

        btnWeb.setOnClickListener {
            updateSelectedState(btnWeb)
            listener?.onOptionSelected("WEB")
        }

        btnBotones.setOnClickListener {
            updateSelectedState(btnBotones)
            listener?.onOptionSelected("BOTONES")
        }
    }

    private fun updateSelectedState(selectedButton: Button) {
        btnPerfil.isSelected = (selectedButton == btnPerfil)
        btnFotos.isSelected = (selectedButton == btnFotos)
        btnVideo.isSelected = (selectedButton == btnVideo)
        btnWeb.isSelected = (selectedButton == btnWeb)
        btnBotones.isSelected = (selectedButton == btnBotones)
    }

}