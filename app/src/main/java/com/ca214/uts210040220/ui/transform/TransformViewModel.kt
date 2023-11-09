package com.ca214.uts210040220.ui.transform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ca214.uts210040220.models.CountyModel

class TransformViewModel : ViewModel() {

    private val _texts = MutableLiveData<List<String>>().apply {
//        var country = CountyModel("Afghanistan","ASIA (EX. NEAR EAST)",31056997,	647500,	48.0,	0.00,	23.06,	163.07,	700.0,	36.0,	3.2,	12.13,	0.22,	87.65,	1.0,46.6,	20.34,	0.38,	0.24,	0.38)
//        var countries = listOf(
//            CountyModel("Afganistan"),
//            CountyModel("Arab"),
//            CountyModel("Indonesia"),
//            CountyModel("Malaysia"),
//            CountyModel("Cambodja"),
//            CountyModel("Korea"),
//            CountyModel("Japan"),
//        )
//        for (prop in countries::class.members) {
//            println(prop.name)
//        }
//        value = countries.map { it.countryName }
//        countries.listIterator()
//        value = (1..16).mapIndexed { _, i ->
//            "This is item # $i"
//        }
    }

    val texts: LiveData<List<String>> = _texts
}