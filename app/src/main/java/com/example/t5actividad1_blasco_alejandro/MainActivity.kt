package com.example.t5actividad1_blasco_alejandro

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5actividad1_blasco_alejandro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var comidaAdapter: ComidaAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        comidaAdapter = ComidaAdapter(ComidaDatos.COMIDAS, this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.rvListaComida.apply {
            layoutManager = linearLayoutManager
            adapter = comidaAdapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(comida: Comida) {
        binding.wvWebView.webViewClient = WebViewClient()
        var url = "https://es.wikipedia.org/wiki/"
        binding.wvWebView.loadUrl(url + comida.getNombre())
        binding.wvWebView.visibility = View.VISIBLE
        binding.rvListaComida.visibility = View.GONE
    }
    override fun onBackPressed() {
        if (binding.wvWebView.visibility == View.VISIBLE) {
            binding.wvWebView.visibility = View.GONE
            binding.rvListaComida.visibility = View.VISIBLE
        } else {
            super.onBackPressed()
        }
}
    }