package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), OnMenuOptionSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar el menú izquierdo si es la primera vez que se crea la actividad
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.leftPane, LeftMenuFragment())
                .commit()
            
            // Opcional: Cargar "Perfil" por defecto al abrir la app
            onOptionSelected("PERFIL")
        }
    }

    // Este método responde a los clics del menú izquierdo
    override fun onOptionSelected(opcion: String) {
        val fragmentoSeleccionado: Fragment = when (opcion) {
            "PERFIL" -> PerfilFragment() // Los crearemos en el siguiente paso
            "FOTOS" -> FotosFragment()
            "VIDEO" -> VideoFragment()
            "WEB" -> WebFragment()
            "BOTONES" -> BotonesFragment()
            else -> PerfilFragment()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.rightPane, fragmentoSeleccionado)
            .commit()
    }
}