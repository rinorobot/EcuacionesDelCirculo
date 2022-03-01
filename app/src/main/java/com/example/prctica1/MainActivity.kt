package com.example.prctica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.prctica1.databinding.ActivityMainBinding
import com.example.prctica1.models.Ecuaciones
import com.example.prctica1.models.Punto

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var position = 0
    var radio: Double = 0.0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        setTheme(androidx.appcompat.R.style.Theme_AppCompat)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val equations = resources.getStringArray(R.array.equations_array)
        setContentView(binding.root)


        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,equations)
        binding.menu.adapter = adapter

        binding.menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                position = pos

                when (pos) {
                    0 -> {
                        binding.etA.visibility = View.INVISIBLE
                        binding.etB.visibility = View.INVISIBLE
                        binding.etR.visibility = View.INVISIBLE
                        binding.etX.visibility = View.INVISIBLE
                        binding.etY.visibility = View.INVISIBLE
                        binding.ivFormula.setImageResource(R.drawable.grafico_circular)

                    }
                    1 -> {
                        binding.etA.visibility = View.VISIBLE
                        binding.etB.visibility = View.VISIBLE
                        binding.etR.visibility = View.VISIBLE
                        binding.etX.visibility = View.INVISIBLE
                        binding.etY.visibility = View.INVISIBLE


                        binding.ivFormula.setImageResource(R.drawable.forma_estandar)

                    }
                    2 -> {
                        binding.etA.visibility = View.VISIBLE
                        binding.etB.visibility = View.VISIBLE
                        binding.etR.visibility = View.VISIBLE
                        binding.etX.visibility = View.INVISIBLE
                        binding.etY.visibility = View.INVISIBLE
                        binding.ivFormula.setImageResource(R.drawable.forma_general)
                    }
                    3 -> {
                        binding.ivFormula.setImageResource(R.drawable.radio)
                        binding.etA.visibility = View.VISIBLE
                        binding.etB.visibility = View.VISIBLE
                        binding.etR.visibility = View.INVISIBLE
                        binding.etX.visibility = View.VISIBLE
                        binding.etY.visibility = View.VISIBLE

                    }
                }
            }



            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.btnCalcular.setOnClickListener {


            if(position == 0){
                binding.menu.requestFocus()
                Toast.makeText(this,getString(R.string.elige_formula),Toast.LENGTH_LONG).show()
            }
           else if (validarCampos()){
                if (position==1){
                    radio = Math.sqrt(Math.pow(binding.etA.text.toString().toDouble(),2.0)+Math.pow(binding.etA.text.toString().toDouble(),2.0))
                    if (binding.etR.text.toString()==""){
                        binding.etR.error = getString(R.string.requerir)
                        binding.etR.requestFocus()
                    }
                    else if(binding.etR.text.toString().toDouble()<radio){
                        binding.etR.error = getString(R.string.radio_aviso)+" ${radio.toFloat()}"
                        binding.etR.requestFocus()
                    }else{
                       val intent = Intent(this@MainActivity,FormaEstandard::class.java)
                       val estandar = Ecuaciones(binding.etA.text.toString(),binding.etB.text.toString(),binding.etR.text.toString())
                       val bundle = Bundle()

                       bundle.putSerializable("ordinaria",estandar)

                       intent.putExtras(bundle)
                       startActivity(intent)
                    }



                } else if (position==2){
                    radio = Math.sqrt(Math.pow(binding.etA.text.toString().toDouble(),2.0)+Math.pow(binding.etA.text.toString().toDouble(),2.0))
                   if (binding.etR.text.toString()==""){
                        binding.etR.error = getString(R.string.requerir)
                        binding.etR.requestFocus()
                    }

                   else if(binding.etR.text.toString().toDouble()<radio){//Validación para que el radio esté dentro del rango
                        binding.etR.error = getString(R.string.radio_aviso)+" ${radio.toFloat()}"
                        binding.etR.requestFocus()
                    }else {
                        val intent = Intent(this@MainActivity, FormaGeneral::class.java)
                        val general = Ecuaciones(
                            binding.etA.text.toString(),
                            binding.etB.text.toString(),
                            binding.etR.text.toString()
                        )
                        val bundle = Bundle()

                        bundle.putSerializable("general", general)

                        intent.putExtras(bundle)
                        startActivity(intent)
                    }

                } else if (position==3){

                    if (binding.etX.text.toString()==""){
                        binding.etX.error = getString(R.string.requerir)
                        binding.etX.requestFocus()
                    }
                    else if (binding.etY.text.toString()==""){

                        binding.etY.error = getString(R.string.requerir)
                        binding.etY.requestFocus()
                    }else{
                        val intent = Intent(this@MainActivity,Radio::class.java)
                        val coordenadas = Punto(binding.etA.text.toString(),binding.etB.text.toString(),binding.etX.text.toString(),binding.etY.text.toString())
                        val bundle = Bundle()

                        bundle.putParcelable("coordenadas",coordenadas)

                        intent.putExtras(bundle)
                        startActivity(intent)
                    }






                }
            }else{


                if (binding.etA.text.toString()==""){
                   binding.etA.error = getString(R.string.requerir)
                   binding.etA.requestFocus()
               } else if (binding.etB.text.toString()==""){
                    binding.etB.error = getString(R.string.requerir)
                    binding.etB.requestFocus()
                }




            }



        }




    }

    private fun validarCampos():Boolean{




           return binding.etA.text.toString() != "" && binding.etB.text.toString() != ""



    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent= Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
        finish()
    }


}