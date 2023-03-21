package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Tout : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    lateinit var login_button: Button
    lateinit var question_answer_tv: TextView
    lateinit var setting_tv: TextView
    lateinit var help_tv: TextView
    lateinit var medication_stimulant: TextView
    lateinit var continuous_monitoring: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tout)

        initializeViews()

        /*login_button.setOnClickListener() {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }*/
        continuous_monitoring.setOnClickListener() {
            val intent = Intent(this, Continuous::class.java)
            startActivity(intent)
        }
        question_answer_tv.setOnClickListener() {
            val intent = Intent(this, Question_answer::class.java)
            startActivity(intent)
        }

        help_tv.setOnClickListener() {
            // val intent = Intent(this, ::class.java)
            // startActivity(intent)
        }
        setting_tv.setOnClickListener() {
            //  val intent = Intent(this, Login::class.java)
            // startActivity(intent)
        }
        medication_stimulant.setOnClickListener() {
            val intent = Intent(this, Medicine::class.java)
            startActivity(intent)
        }

        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    true
                }
                R.id.favorites -> {
                    true
                }
                R.id.clean -> {
                    true
                }
                R.id.dark_mode -> {
                    true
                }
                R.id.french -> {
                    true
                }
                R.id.arab -> {
                    true
                }
                R.id.english -> {
                    true
                }
                R.id.contact -> {
                    true
                }
                R.id.share -> {
                    true
                }
                R.id.rate -> {
                    true
                }
                else -> false
            }
        }
    }

    private fun initializeViews() {
        drawerLayout = findViewById(R.id.drawer_layout)
//        login_button = findViewById(R.id.login_btn)
        question_answer_tv = findViewById(R.id.question_answer)
        continuous_monitoring = findViewById(R.id.Continuous_monitoring)
        medication_stimulant = findViewById(R.id.Medication_stimulant)
        help_tv = findViewById(R.id.help)
        setting_tv = findViewById(R.id.setting)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}