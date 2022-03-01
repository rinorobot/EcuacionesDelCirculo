package com.example.prctica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prctica1.databinding.ActivityFormaGeneralBinding
import com.example.prctica1.models.Ecuaciones

class FormaGeneral : AppCompatActivity() {
    lateinit var binding: ActivityFormaGeneralBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityFormaGeneralBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val general = bundle?.getSerializable("general") as Ecuaciones


        val A  = -2.0*general.a.toDouble()
        val B = -2*general.b.toDouble()
        val C = Math.pow(general.a.toDouble(),2.0)+Math.pow(general.b.toDouble(),2.0)-Math.pow(general.r.toDouble(),2.0)


        binding.tvGeneral.text = getString(R.string.general_resul,A,B,C)

    }
}