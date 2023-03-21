package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


@Suppress("DEPRECATION")
class Home : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: AdapterClass
    private lateinit var drawerLayout: DrawerLayout
    lateinit var loginBtn:Button
    lateinit var bottomNavigationView:BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


      /* val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
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


        loginBtn=findViewById(R.id.login_button)
        loginBtn.setOnClickListener(){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this)

             foodList= ArrayList()

              foodList.add(Food(R.drawable.ic_list,getString(R.string.diet_1)))
              foodList.add(Food(R.drawable.ic_checkbox,getString(R.string.diet_2)))
              foodList.add(Food(R.drawable.ic_image,getString(R.string.diet_3)))
              foodList.add(Food(R.drawable.ic_toggle,getString(R.string.diet_4)))
              foodList.add(Food(R.drawable.ic_date,getString(R.string.diet_5)))
              foodList.add(Food(R.drawable.ic_rating,getString(R.string.diet_6)))
              foodList.add(Food(R.drawable.ic_time,getString(R.string.diet_7)))
              foodList.add(Food(R.drawable.ic_text,getString(R.string.diet_8)))


              foodAdapter= AdapterClass(foodList)
              recyclerView.adapter=foodAdapter

              foodAdapter.onItemClick={
                  val intent=Intent(this,DetailedActivity::class.java)
                  intent.putExtra("food",it)
                  startActivity(intent)
              }


val navigationView: NavigationView = findViewById(R.id.navigation_view)
navigationView.setNavigationItemSelectedListener { menuItem ->
    when (menuItem.itemId) {
        R.id.home -> { true }
        R.id.favorites -> { true }
        R.id.clean -> { true }
        R.id.french -> { true }
        R.id.arab -> { true }
        R.id.english -> { true }
        R.id.dark_mode -> { true }
        R.id.contact -> { true }
        R.id.share -> { true }
        R.id.rate-> { true }
        else -> false
    }
  }


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
       private fun makeCurrentFragment(fragment: Fragment) =
           supportFragmentManager.beginTransaction().apply {
           replace(R.id.fl_wrapper, fragment)
           commit()
       }
}