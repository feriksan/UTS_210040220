package com.ca214.uts210040220

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ca214.uts210040220.models.CountyModel

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
        holder.editButton.setOnClickListener {
            println("Edit" + country.countryName)
            onEditClick?.invoke(country)
        }
        holder.itemView.setOnClickListener{
            println(onItemClick)
            onItemClick?.invoke(country)
        }

        holder.deleteButton.setOnClickListener {
            println("Delete" + country.countryName)
            onDeleteClick?.invoke(country)
        }

    }
    override fun getItemCount(): Int {
        return countryList.size
    }

    private val drawables = listOf(
        R.drawable.avatar_1,
        R.drawable.avatar_2,
        R.drawable.avatar_3,
        R.drawable.avatar_4,
        R.drawable.avatar_5,
        R.drawable.avatar_6,
        R.drawable.avatar_7,
        R.drawable.avatar_8,
        R.drawable.avatar_9,
        R.drawable.avatar_10,
        R.drawable.avatar_11,
        R.drawable.avatar_12,
        R.drawable.avatar_13,
        R.drawable.avatar_14,
        R.drawable.avatar_15,
        R.drawable.avatar_16,
    )
}