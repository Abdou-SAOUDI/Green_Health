package com.example.projet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val food=intent.getParcelableExtra<Food>("food")
        if (food!=null){
            val textView: TextView =findViewById(R.id.detailedActivityTv)
            val imageView: ImageView =findViewById(R.id.detailedActivityIv)

            textView.text=food.title
            imageView.setImageResource(food.image)

        }
    }
}