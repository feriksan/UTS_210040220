package com.ca214.uts210040220.models

data class CountyModel(
    var countryName: String = "",
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
)
