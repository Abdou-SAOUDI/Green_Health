package com.example.projet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DiseaseAdapter(private val diseaseList: ArrayList<Diseases_list>)
    :RecyclerView.Adapter<DiseaseAdapter.DiseaseViewHolder>(){
    class DiseaseViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.imageView)
        val textView:TextView=itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiseaseViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return DiseaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiseaseViewHolder, position: Int) {
        val disease=diseaseList[position]
        holder.imageView.setImageResource(disease.image)
        holder.textView.text=disease.title
    }

    override fun getItemCount(): Int {
        return diseaseList.size
    }
}