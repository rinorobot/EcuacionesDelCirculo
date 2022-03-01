package com.example.prctica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prctica1.databinding.ActivityFormaEstandardBinding
import com.example.prctica1.models.Ecuaciones

class FormaEstandard : AppCompatActivity() {

    lateinit var binding : ActivityFormaEstandardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormaEstandardBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val bundle = intent.extras

        val ordinaria = bundle?.getSerializable("ordinaria") as Ecuaciones

        val r2 = Math.pow(ordinaria.r.toDouble(),2.0)
        val h = ordinaria.a.toDouble()
        val k = ordinaria.b.toDouble()


        binding.tvOrdinaria.text = getString(R.string.ordinaria_resul,r2,h,k)






    }
}