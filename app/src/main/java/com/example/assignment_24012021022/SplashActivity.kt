package com.example.assignment_24012021022

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.selects.SelectInstance
import org.w3c.dom.Text

class SplashActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_splash)

        val logo = findViewById<ImageView>(R.id.splash_logo)
        val title = findViewById<TextView>(R.id.tv_app_name)

        // fade in animation
        logo.alpha = 0f
        title.alpha = 0f
        logo.animate().alpha(1f).setDuration(1000).start()
        title.animate().alpha(1f).setDuration(1200).start()

        // now wait to 2 seconds to launch MainActivity.kt

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
//            finish()  // calling finish so user can't press back button into splash .
        } , 2000)

    }
}