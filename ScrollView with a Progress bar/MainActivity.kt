package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            sv_wrapper.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                val totalScrollLength = sv_wrapper.getChildAt(0).height - sv_wrapper.height
                progressBar.apply {
                    max = totalScrollLength
                    progress = scrollY
                }
            }
        }
    }
}