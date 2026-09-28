package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class FotosFragment : Fragment(R.layout.fragment_fotos) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgLibro1 = view.findViewById<ImageView>(R.id.imgLibro1)
        val imgLibro2 = view.findViewById<ImageView>(R.id.imgLibro2)
        val imgLibro3 = view.findViewById<ImageView>(R.id.imgLibro3)
        val tvDescripcion = view.findViewById<TextView>(R.id.tvDescripcionLibro)

        val urlLibro1 = "https://covers.openlibrary.org/b/isbn/9780141187761-L.jpg" // 1984
        val urlLibro2 = "https://covers.openlibrary.org/b/isbn/9780132350884-L.jpg" // Clean Code
        val urlLibro3 = "https://covers.openlibrary.org/b/isbn/9780156012195-L.jpg" // El Principito

        cargarImagenDesdeInternet(urlLibro1, imgLibro1)
        cargarImagenDesdeInternet(urlLibro2, imgLibro2)
        cargarImagenDesdeInternet(urlLibro3, imgLibro3)

        imgLibro1.setOnClickListener {
            tvDescripcion.text = "Título: 1984\nAutor: George Orwell\nAño: 1949\n\nISBN: 9780141187761\nCargado desde: Open Library API"
        }

        imgLibro2.setOnClickListener {
            tvDescripcion.text = "Título: Clean Code\nAutor: Robert C. Martin\nAño: 2008\n\nISBN: 9780132350884\nCargado desde: Open Library API"
        }

        imgLibro3.setOnClickListener {
            tvDescripcion.text = "Título: El Principito\nAutor: Antoine de Saint-Exupéry\nAño: 1943\n\nISBN: 9780156012195\nCargado desde: Open Library API"
        }
    }

    // Función que descarga la imagen sin bloquear la interfaz gráfica
    private fun cargarImagenDesdeInternet(url: String, imageView: ImageView) {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val inputStream = URL(url).openStream()
                val bitmap: Bitmap = BitmapFactory.decodeStream(inputStream)

                withContext(Dispatchers.Main) {
                    imageView.setImageBitmap(bitmap)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}