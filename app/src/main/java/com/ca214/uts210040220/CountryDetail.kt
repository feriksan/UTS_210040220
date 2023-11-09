package com.ca214.uts210040220

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.ca214.uts210040220.models.CountyModel

class CountryDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        val country = intent.getParcelableExtra<CountyModel>("country")
        if(country != null){
            val textView: TextView = findViewById(R.id.countryDetailTittle)
            val imageView: ImageView = findViewById(R.id.countryDetailFlag)
            val textDetail: TextView = findViewById(R.id.countryDetailDesc)
            textView.text = country.countryName
            imageView.setImageResource(country.countryFlag)
            textDetail.text = country.countryDesc
        }

    }
}