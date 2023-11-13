package com.ca214.uts210040220

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.core.text.set
import com.ca214.uts210040220.models.CountyModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class EditCountry : AppCompatActivity() {
    val gson = Gson()
    var countryListNew = ArrayList<CountyModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_country)

        val country = intent.getParcelableExtra<CountyModel>("country")
        if(country != null){
            val name: EditText = findViewById(R.id.countryNameEdit)
            val region: EditText = findViewById(R.id.countryRegionEdit)
            val desc: EditText = findViewById(R.id.countryDescEdit)
            val actionBar: ActionBar? = supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)
            name.setText(country.countryName)
            desc.setText(country.countryDesc)
            val intent = Intent()
            val sharedPreferences = getSharedPreferences("countries", MODE_PRIVATE)
            val json = sharedPreferences.getString("country", null)
            val type: Type = object : TypeToken<ArrayList<CountyModel?>?>() {}.type
            countryListNew = gson.fromJson<Any>(json, type) as ArrayList<CountyModel>
            findViewById<Button>(R.id.submitButtonEdit).setOnClickListener {
                val changeCountry : CountyModel = CountyModel(R.drawable.avatar_2, name.text.toString(), desc.text.toString(), region.text.toString())
                countryListNew[countryListNew.indexOf(country)] = changeCountry
                val json: String = gson.toJson(countryListNew)
                val editor = sharedPreferences.edit()
                editor.putString("country", json)
                editor.apply()
                intent.putExtra("ActivityResult", countryListNew)
                setResult(RESULT_OK, intent)
                finish()
                onBackPressed()
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        intent.putExtra("ActivityResult", countryListNew)
        setResult(RESULT_OK, intent)
        finish()
        onBackPressed()
        return true
    }
}