package com.example.prctica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val intent = Intent(this,MainActivity::class.java)
        val handler = Handler()
        handler.postDelayed({
            startActivity(intent)
        }, 3000)

    }
}