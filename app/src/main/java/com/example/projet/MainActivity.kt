package com.example.projet


import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import java.util.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    lateinit var start: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start=findViewById(R.id.start_btn)
        start.setOnClickListener {
            val intent = Intent(this,MainHome::class.java)
            startActivity(intent)
        }

        //for the language
        val res1: Resources =this.resources
        val dm1 : DisplayMetrics =res1.displayMetrics
        val conf1: Configuration =res1.configuration
        conf1.setLocale(Locale("en"))
        res1.updateConfiguration(conf1,dm1)
    }

   /* fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_wrapper,fragment)
        fragmentTransaction.commit()
    }*/
}