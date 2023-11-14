package com.ca214.uts210040220

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ca214.uts210040220.models.CountyModel
import java.util.concurrent.Executors

class CountryAdapter(val countryList: ArrayList<CountyModel>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder(itemBinding: View): RecyclerView.ViewHolder(itemBinding){
        val imageView : ImageView = itemBinding.findViewById(R.id.countryFlag)
        val textView : TextView = itemBinding.findViewById(R.id.countryName)
        val editButton : Button = itemBinding.findViewById(R.id.edit)
        val deleteButton : Button = itemBinding.findViewById(R.id.delete)
    }

    var onItemClick : ((CountyModel) -> Unit)? = null
    var onEditClick : ((CountyModel) -> Unit)? = null
    var onDeleteClick : ((CountyModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_transform_list, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.imageView.setImageResource(country.countryFlag)
        holder.textView.text = country.countryName
        //Button Edit Handler
        holder.editButton.setOnClickListener {
            println("Edit" + country.countryName)
            onEditClick?.invoke(country)
        }
        //Item Click Handler
        holder.itemView.setOnClickListener{
            println(onItemClick)
            onItemClick?.invoke(country)
        }
        //Long Click Handler
        holder.itemView.setOnLongClickListener(){
            println("Edit" + country.countryName)
            onEditClick?.invoke(country)
            true
        }
        //Button Delete Handler
        holder.deleteButton.setOnClickListener {
            println("Delete" + country.countryName)
            onDeleteClick?.invoke(country)
        }

    }
    override fun getItemCount(): Int {
        return countryList.size
    }

}