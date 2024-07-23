package com.sample.ktln02

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val findBeer = findViewById<Button>(R.id.btnFindBeer)
        findBeer.setOnClickListener {
            val bearColor = findViewById<Spinner>(R.id.spnBeerColor)
            val color = "${bearColor.selectedItem}"
            val beerList = getBeers(color)
            val beers = beerList.reduce { str, item -> str + '\n' + item}
            val brand = findViewById<TextView>(R.id.tvBeerBrands)
//            val message = "Beer color is $color"
            brand.text = beers
        }
    }
    fun getBeers(color: String): List<String>{
        return when (color){
            "Light" -> listOf("Jail Pale Al", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Shout", "Dark Daniel")
        }
    }
}