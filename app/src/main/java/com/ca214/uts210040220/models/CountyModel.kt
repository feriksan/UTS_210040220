package com.ca214.uts210040220.models

import android.os.Parcel
import android.os.Parcelable

data class CountyModel(
    var countryFlag: Int = 0,
    var countryName: String = "",
    var countryDesc: String = "",
    var regionName: String = "",
    var population: Int = 0,
    var area: Int = 0,
    var populationDensity: Double = 1.0,
    var coastline: Double = 1.0,
    var netMigration: Double = 1.0,
    var infantMortality: Double = 1.0,
    var gdp: Double = 1.0,
    var literacy: Double = 1.0,
    var phones: Double = 1.0,
    var arable: Double = 1.0,
    var crops: Double = 1.0,
    var other: Double = 1.0,
    var climate: Double = 1.0,
    var birthrate: Double = 1.0,
    var deathrate: Double = 1.0,
    var agriculture: Double = 1.0,
    var industry: Double = 1.0,
    var service: Double = 1.0
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(countryFlag)
        parcel.writeString(countryName)
        parcel.writeString(countryDesc)
        parcel.writeString(regionName)
        parcel.writeInt(population)
        parcel.writeInt(area)
        parcel.writeDouble(populationDensity)
        parcel.writeDouble(coastline)
        parcel.writeDouble(netMigration)
        parcel.writeDouble(infantMortality)
        parcel.writeDouble(gdp)
        parcel.writeDouble(literacy)
        parcel.writeDouble(phones)
        parcel.writeDouble(arable)
        parcel.writeDouble(crops)
        parcel.writeDouble(other)
        parcel.writeDouble(climate)
        parcel.writeDouble(birthrate)
        parcel.writeDouble(deathrate)
        parcel.writeDouble(agriculture)
        parcel.writeDouble(industry)
        parcel.writeDouble(service)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountyModel> {
        override fun createFromParcel(parcel: Parcel): CountyModel {
            return CountyModel(parcel)
        }

        override fun newArray(size: Int): Array<CountyModel?> {
            return arrayOfNulls(size)
        }
    }

}
