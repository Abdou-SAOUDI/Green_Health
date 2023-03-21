package com.example.projet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainHome : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var loginBtn:Button
    lateinit var storesBtn: CardView
    lateinit var dietsBtn:CardView
    lateinit var doctors_accountBtn:CardView
    lateinit var sport_routineBtn:CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        initializeViews()


        loginBtn.setOnClickListener(){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        storesBtn.setOnClickListener(){
            val intent = Intent(this, Stores::class.java)
            startActivity(intent)
        }

        dietsBtn.setOnClickListener(){
            val intent = Intent(this, Disease::class.java)
            startActivity(intent)
        }

        doctors_accountBtn.setOnClickListener(){
            val intent = Intent(this, Doctors::class.java)
            startActivity(intent)
        }

        sport_routineBtn.setOnClickListener(){
            val intent = Intent(this, Sport::class.java)
            startActivity(intent)
        }

        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> { true }
                R.id.favorites -> { true }
                R.id.clean -> { true }
                R.id.dark_mode -> { true }
                R.id.french -> { true }
                R.id.arab -> { true }
                R.id.english -> { true }
                R.id.contact -> { true }
                R.id.share -> { true }
                R.id.rate-> { true }
                else -> false
            }
        }
      }

    private fun initializeViews() {
        loginBtn=findViewById(R.id.login_button)
        storesBtn=findViewById(R.id.stores_btn)
        dietsBtn=findViewById(R.id.diets_btn)
        doctors_accountBtn=findViewById(R.id.doctors_account_btn)
        sport_routineBtn=findViewById(R.id.sport_routine_btn)
    }

}