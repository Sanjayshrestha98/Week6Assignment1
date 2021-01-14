package com.example.week6assignment1.ui.aboutus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.week6assignment1.R

class AboutusFragment : Fragment() {

    private lateinit var aboutusViewModel: AboutusViewModel
    private lateinit var webview: WebView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutusViewModel =
            ViewModelProvider(this).get(AboutusViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_aboutus, container, false)

        webview = root.findViewById(R.id.webview)
        webview.loadUrl("https://softwarica.edu.np/")


        return root
    }
}