package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity(), OnMenuOptionSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: MaterialToolbar
    private lateinit var tvTituloVista: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolbar)
        tvTituloVista = findViewById(R.id.tvTituloVista)

        setSupportActionBar(toolbar)

        // El título de la barra superior siempre muestra el nombre de la app
        toolbar.title = "OpenBook"

        // Aplicar padding interno en el Toolbar para el contenido (safe area) mientras el fondo se estira
        ViewCompat.setOnApplyWindowInsetsListener(toolbar) { view, insets ->
            val statusBarTop = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            view.updatePadding(top = statusBarTop)
            insets
        }

        // Aplicar padding interno al menú lateral para la barra de estado y de navegación
        val leftPane = findViewById<FragmentContainerView>(R.id.leftPane)
        ViewCompat.setOnApplyWindowInsetsListener(leftPane) { view, insets ->
            val statusBarTop = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            val navBarBottom = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
            view.updatePadding(top = statusBarTop, bottom = navBarBottom)
            insets
        }

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        // Icono de drawer en color blanco para resaltar
        toggle.drawerArrowDrawable.color = Color.WHITE
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        toolbar.setNavigationOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        // Cargar el menú izquierdo si es la primera vez que se crea la actividad
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.leftPane, LeftMenuFragment())
                .commit()

            // Cargar "Perfil" por defecto al abrir la app
            onOptionSelected("PERFIL")
        }
    }

    // Este método responde a los clics del menú izquierdo
    override fun onOptionSelected(opcion: String) {
        val fragmentoSeleccionado: Fragment = when (opcion) {
            "PERFIL" -> PerfilFragment()
            "FOTOS" -> FotosFragment()
            "VIDEO" -> VideoFragment()
            "WEB" -> WebFragment()
            "BOTONES" -> BotonesFragment()
            else -> PerfilFragment()
        }

        // Actualizar el título de la vista actual debajo del appbar
        tvTituloVista.text = when (opcion) {
            "PERFIL" -> "Perfil"
            "FOTOS" -> "Fotos (Libros)"
            "VIDEO" -> "Video"
            "WEB" -> "Web"
            "BOTONES" -> "Botones"
            else -> "Perfil"
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.rightPane, fragmentoSeleccionado)
            .commit()

        // Cerrar menú lateral al seleccionar una opción
        drawerLayout.closeDrawer(GravityCompat.START)
    }

}