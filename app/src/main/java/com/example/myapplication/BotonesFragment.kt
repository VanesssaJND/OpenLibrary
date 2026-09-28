package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment

class BotonesFragment : Fragment(R.layout.fragment_botones) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAccion = view.findViewById<Button>(R.id.btnAccion)
        val switchModo = view.findViewById<Switch>(R.id.switchModo)
        val tvResultado = view.findViewById<TextView>(R.id.tvResultadoEvento)

        btnAccion.setOnClickListener {
            tvResultado.text = "Evento disparado:\nSe presionó el Botón de Acción Estándar."
        }

        switchModo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tvResultado.text = "Evento disparado:\nSwitch activado (Modo Oscuro ON)."
            } else {
                tvResultado.text = "Evento disparado:\nSwitch desactivado (Modo Oscuro OFF)."
            }
        }
    }
}