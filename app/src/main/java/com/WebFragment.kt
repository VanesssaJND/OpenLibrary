package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class WebFragment : Fragment(R.layout.fragment_web) {

    private lateinit var etUrl: EditText
    private lateinit var btnCargarWeb: Button
    private lateinit var webViewOpenLibrary: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etUrl = view.findViewById(R.id.etUrl)
        btnCargarWeb = view.findViewById(R.id.btnCargarWeb)
        webViewOpenLibrary = view.findViewById(R.id.webViewOpenLibrary)

        webViewOpenLibrary.settings.javaScriptEnabled = true
        webViewOpenLibrary.webViewClient = WebViewClient() 

        val urlPorDefecto = "https://openlibrary.org"
        etUrl.setText(urlPorDefecto)
        webViewOpenLibrary.loadUrl(urlPorDefecto)

        btnCargarWeb.setOnClickListener {
            val nuevaUrl = etUrl.text.toString()
            if (nuevaUrl.isNotEmpty()) {

                val urlCompleta = if (!nuevaUrl.startsWith("http://") && !nuevaUrl.startsWith("https://")) {
                    "https://$nuevaUrl"
                } else {
                    nuevaUrl
                }
                webViewOpenLibrary.loadUrl(urlCompleta)
            }
        }
    }
}