package com.ca214.uts210040220

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.ca214.uts210040220.databinding.ItemTransformListBinding

class CountryAdapter(val countryList: ArrayList<String>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var _binding: ItemTransformListBinding? = null
    inner class CountryViewHolder(itemBinding: ItemTransformListBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        _binding = ItemTransformListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CountryViewHolder(_binding!!)
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

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = countryList[position]

        holder.itemView.apply {
            _binding?.countryName?.text = item
        }
        holder.itemView.apply {
            _binding?.countryFlag?.setImageDrawable(
                ResourcesCompat.getDrawable(holder.itemView.resources, drawables[position], null)
            )
        }
    }
}