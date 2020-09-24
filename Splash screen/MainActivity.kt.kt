
package com.example.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Going full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        //Declaration of used variables
        val appTextView: TextView=findViewById(R.id.ApptextView)
        val tagTextView=findViewById<TextView>(R.id.tagLine)
        val logoImageView=findViewById<ImageView>(R.id.LogoimageView)

        //Animations

        val topAnim=AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnim= AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        //Setting animations to the TextView and ImageView

        appTextView.startAnimation(bottomAnim)
        tagTextView.startAnimation(bottomAnim)
        logoImageView.startAnimation(topAnim)

        handler= Handler()
        handler.postDelayed({
            val intent= Intent(this.applicationContext, NexAtctivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
