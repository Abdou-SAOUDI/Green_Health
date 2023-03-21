@file:Suppress("DEPRECATION")

package com.example.projet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.view.GravityCompat
import androidx.core.widget.doOnTextChanged
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class Login : AppCompatActivity() {

    lateinit var nav_view:BottomNavigationView
    private lateinit var drawerLayout: DrawerLayout
    lateinit var username : EditText
    lateinit var loginBtn: Button
    lateinit var sendBtn: Button
    lateinit var phoneEt: TextInputEditText
    lateinit var phoneL: TextInputLayout
    lateinit var codeEt: TextInputEditText
    lateinit var codeL: TextInputLayout


    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initializeViews()

        loginBtn.setOnClickListener(){
            val intent = Intent(this,Tout::class.java)
            startActivity(intent)
        }

        phoneEt.doOnTextChanged { text, start, before, count -> run {
            if (phoneEt.length() > 9) {
                phoneL.error="No More"
            }else if(phoneEt.length() <= 9){
                 phoneL.error=null
            }
        }
          /*  codeEt.doOnTextChanged { text, start, before, count -> run {
                if (codeEt.length() > 5) {
                    codeL.error="No More !!!"
                }else if(codeEt.length() <= 5){
                    codeL.error=null
                }
            }
            }*/


        // for Radio Button
        val rdGroup=findViewById<RadioGroup>(R.id.radioGroup)
        val btn1=findViewById<RadioButton>(R.id.radioButton1)
        val btn2=findViewById<RadioButton>(R.id.radioButton2)
        btn1.setOnClickListener {
            val selectBtn: Int = rdGroup!!.checkedRadioButtonId
            val btn = findViewById<RadioButton>(selectBtn)
            Toast.makeText(this, btn.text, Toast.LENGTH_SHORT).show()
        }
        btn2.setOnClickListener {
            val selectBtn: Int = rdGroup!!.checkedRadioButtonId
            val btn = findViewById<RadioButton>(selectBtn)
            Toast.makeText(this, btn.text, Toast.LENGTH_SHORT).show()
        }


        findViewById<ImageView>(R.id.start_l).setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        })

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

        /*  val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
           when (menuItem.itemId) {
               R.id.home -> { true }
               R.id.more -> { true }
               R.id.settings -> { true }
               R.id.favorites -> { true }
               else -> false
           }
       }

        val homeFragment= HomeFragment()
        val moreFragment= MoreFragment()
        makeCurrentFragment(moreFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener {
         when (it.itemId) {
           R.id.home -> makeCurrentFragment(homeFragment)
           R.id.more -> makeCurrentFragment(moreFragment)
        }
       true
       }*/




    }


}
    fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
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

    private fun initializeViews() {
        nav_view=findViewById(R.id.bottomNavigationView)
        drawerLayout=findViewById(R.id.drawer_layout)
        username=findViewById(R.id.usernameEditText)
        loginBtn=findViewById(R.id.loginButton)
        phoneEt=findViewById(R.id.phoneNumberEditText)
        phoneL=findViewById(R.id.phoneNumber)
        codeEt=findViewById(R.id.codeEditText)
        codeL=findViewById(R.id.code)
    }
}





