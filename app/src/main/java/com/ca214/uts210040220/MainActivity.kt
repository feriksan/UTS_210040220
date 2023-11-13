package com.ca214.uts210040220

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ca214.uts210040220.models.CountyModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var countryList : ArrayList<CountyModel>
    private lateinit var countryAdapter: CountryAdapter
    val gson = Gson()

    private val LIST_VIEW = "LIST_VIEW"
    private val GRID_VIEW = "GRID_VIEW"
    var currentView = LIST_VIEW

    val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            val data : ArrayList<CountyModel> = it.data?.getParcelableArrayListExtra("ActivityResult")!!
            countryList = data
            updateSharedPreference(countryList)
            countryAdapter.notifyDataSetChanged();
//            countryAdapter.notifyItemChanged(2)
    }
    val addResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            val data: CountyModel =
                it.data?.getParcelableExtra("ActivityResult")!!
            countryList.add(data)
            updateSharedPreference(countryList)
            countryAdapter.notifyItemInserted(countryList.size - 1)
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // calling the action bar
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        countryList = getItemList()
        val json: String = gson.toJson(countryList)
        val sharedPreferences = getSharedPreferences("countries", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("country", json)
        editor.apply()

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            println("Ganti")
            if(currentView == LIST_VIEW){
                gridView()
            }else{
                listView()
            }
        }

        findViewById<FloatingActionButton>(R.id.addButton).setOnClickListener{
            val intent = Intent(this, AddCountry::class.java)
            addResult.launch(intent)
        }
    }

    // this event will enable the back
    // function to the button on press
    override fun onContextItemSelected(item: MenuItem): Boolean {
        println("GAnti")
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    private fun getItemList(): ArrayList<CountyModel>{
        val list = ArrayList<CountyModel>()

        list.add(CountyModel(R.drawable.avatar_1, "Indonesia", "Indonesia (pelafalan dalam bahasa Indonesia: [in.ˈdo.nɛ.sja]), dikenal dengan nama resmi Republik Indonesia atau lebih lengkapnya Negara Kesatuan Republik Indonesia, adalah negara kepulauan di Asia Tenggara yang dilintasi garis khatulistiwa dan berada di antara daratan benua Asia dan Oseania sehingga dikenal sebagai negara lintas benua, serta antara Samudra Pasifik dan Samudra Hindia.\n" +
                "\n" +
                "Indonesia merupakan negara terluas ke-14 sekaligus negara kepulauan terbesar di dunia dengan luas wilayah sebesar 1.904.569 km²,[13] serta negara dengan pulau terbanyak ke-6 di dunia, dengan jumlah 17.504 pulau.[14] Nama alternatif yang dipakai untuk kepulauan Indonesia disebut Nusantara.[15] Selain itu, Indonesia juga menjadi negara berpenduduk terbanyak ke-4 di dunia dengan penduduk mencapai 277.749.853 jiwa pada tahun 2022,[16] serta negara dengan penduduk beragama Islam terbanyak di dunia, dengan penganut lebih dari 238.875.159 jiwa atau sekitar 86,9%.[17][18] Indonesia adalah negara multiras, multietnis, dan multikultural di dunia, seperti halnya Amerika Serikat.[19]\n" +
                "\n" +
                "Indonesia berbatasan dengan sejumlah negara di Asia Tenggara dan Oseania. Indonesia berbatasan di wilayah darat dengan Malaysia di Pulau Kalimantan dan Sebatik, dengan Papua Nugini di Pulau Papua, dan dengan Timor Leste di Pulau Timor. Negara yang hanya berbatasan laut dengan Indonesia adalah Singapura, Filipina, Australia, Thailand, Vietnam, Palau, dan wilayah persatuan Kepulauan Andaman dan Nikobar, India.\n" +
                "\n" +
                "Indonesia adalah negara kesatuan dengan bentuk pemerintahan republik berdasarkan konstitusi yang sah, yaitu Undang-Undang Dasar Negara Republik Indonesia Tahun 1945 (UUD 1945).[20] Berdasarkan UUD 1945 pula, Dewan Perwakilan Rakyat (DPR), Dewan Perwakilan Daerah (DPD), dan Presiden dicalonkan lalu dipilih dalam pemilihan umum."))
        list.add(CountyModel(R.drawable.avatar_3, "Belanda"))
        list.add(CountyModel(R.drawable.avatar_2, "England"))
        return list
    }

    private fun listView(){
        currentView = LIST_VIEW
        recyclerView.layoutManager = LinearLayoutManager(this)
        countryAdapter = CountryAdapter(countryList)
        recyclerView.adapter = countryAdapter
        countryAdapter.onItemClick = {
            val intent = Intent(this, CountryDetail::class.java)
            intent.putExtra("country", it)
            startActivity(intent)
        }
        countryAdapter.onEditClick = {
            val intent = Intent(this, EditCountry::class.java)
            intent.putExtra("country", it)
//            startActivity(intent)
            getResult.launch(intent)
        }

        countryAdapter.onDeleteClick ={
            deleteElement(it)
        }
    }

    private fun gridView(){
        currentView = GRID_VIEW
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        countryAdapter = CountryAdapter(countryList)
        recyclerView.adapter = countryAdapter
        countryAdapter.onItemClick = {
            val intent = Intent(this, CountryDetail::class.java)
            intent.putExtra("country", it)
            startActivity(intent)
        }
        countryAdapter.onEditClick = {
            val intent = Intent(this, EditCountry::class.java)
            intent.putExtra("country", it)
            getResult.launch(intent)
//            startActivity(intent)
        }
        countryAdapter.onDeleteClick ={
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setMessage("Are you sure you want to Delete?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    deleteElement(it)
                }
                .setNegativeButton("No") { dialog, id ->
                    // Dismiss the dialog
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }
    }

    private fun updateSharedPreference(dataUpdate: ArrayList<CountyModel>){
        val sharedPreferences = getSharedPreferences("countries", MODE_PRIVATE)
        val json: String = gson.toJson(dataUpdate)
        val editor = sharedPreferences.edit()
        editor.putString("country", json)
        editor.apply()
    }

    private fun getFromSharedPreference(): ArrayList<CountyModel> {
        val sharedPreferences = getSharedPreferences("countries", MODE_PRIVATE)
        val json = sharedPreferences.getString("country", null)
        val type: Type = object : TypeToken<ArrayList<CountyModel?>?>() {}.type
        return gson.fromJson<Any>(json, type) as ArrayList<CountyModel>
    }

    private fun deleteElement(data: CountyModel){
        countryList.drop(countryList.indexOf(data))
        updateSharedPreference(countryList)
        countryAdapter.notifyItemRemoved(countryList.indexOf(data))
        countryList.remove(data)
    }
}