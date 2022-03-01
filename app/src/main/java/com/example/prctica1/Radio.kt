package com.example.prctica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.prctica1.databinding.ActivityRadioBinding
import com.example.prctica1.models.Ecuaciones
import com.example.prctica1.models.Punto

class Radio : AppCompatActivity() {

    lateinit var binding: ActivityRadioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRadioBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imageView.setImageResource(R.drawable.area)

        val bundle = intent.extras

        val radioBinding = bundle?.getParcelable<Punto>("coordenadas")
        val radio = Math.sqrt(Math.pow(radioBinding?.x!!.toDouble()-radioBinding.A!!.toDouble(),2.0)+Math.pow(radioBinding.y!!.toDouble()-radioBinding.B!!.toDouble(),2.0))
        binding.tvRadio.text = "${radio.toFloat()}"




    }
}