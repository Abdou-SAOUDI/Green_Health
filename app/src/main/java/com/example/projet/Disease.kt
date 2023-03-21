package com.example.projet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class Disease : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var diseaseList: ArrayList<Diseases_list>
    private lateinit var diseaseAdapter: DiseaseAdapter
    private lateinit var drawerLayout: DrawerLayout
    lateinit var loginBtn: Button
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disease)



        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this)

       diseaseList= ArrayList()

        diseaseList.add(Diseases_list(R.drawable.ic_list,getString(R.string.diabetics)))
        diseaseList.add(Diseases_list(R.drawable.ic_checkbox,getString(R.string.kidney_patients)))
        diseaseList.add(Diseases_list(R.drawable.ic_image,getString(R.string.disease1)))
        diseaseList.add(Diseases_list(R.drawable.ic_toggle,getString(R.string.disease2)))
        diseaseList.add(Diseases_list(R.drawable.ic_image,getString(R.string.disease3)))
        diseaseList.add(Diseases_list(R.drawable.ic_toggle,getString(R.string.disease4)))
        diseaseList.add(Diseases_list(R.drawable.ic_image,getString(R.string.disease5)))
        diseaseList.add(Diseases_list(R.drawable.ic_toggle,getString(R.string.disease6)))


        diseaseAdapter= DiseaseAdapter(diseaseList)
        recyclerView.adapter=diseaseAdapter

       /* diseaseAdapter.onItemClick={
            val intent= Intent(this,DetailedActivity::class.java)
            intent.putExtra("food",it)
            startActivity(intent)
        }*/
    }
}