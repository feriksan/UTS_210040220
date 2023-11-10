package com.ca214.uts210040220

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.ca214.uts210040220.models.CountyModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class AddCountry : AppCompatActivity() {
    val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_country2)

        val sharedPreferences = getSharedPreferences("countries", MODE_PRIVATE)
        val json = sharedPreferences.getString("country", null)
        val type: Type = object : TypeToken<ArrayList<CountyModel?>?>() {}.type
        val countryListNew = gson.fromJson<Any>(json, type) as ArrayList<CountyModel>
        val countryName : EditText = findViewById(R.id.countryNameEdit)
        val countryRegion : EditText = findViewById(R.id.countryRegionEdit)
        val countryDesc : EditText = findViewById(R.id.countryDescEdit)
        findViewById<Button>(R.id.submitButtonEdit).setOnClickListener {
            countryListNew.add(CountyModel(R.drawable.avatar_1, countryName.text.toString(), countryDesc.text.toString()))
            val json: String = gson.toJson(countryListNew)
            val editor = sharedPreferences.edit()
            editor.putString("country", json)
            editor.apply()
        }

//        val sharedPreferences = getSharedPreferences("countries", MODE_PRIVATE)
//        val json: String = gson.toJson(countryList)
//        val editor = sharedPreferences.edit()
//        editor.putString("country", json)
//        editor.apply()
    }
}