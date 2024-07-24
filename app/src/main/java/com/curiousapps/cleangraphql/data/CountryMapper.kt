package com.curiousapps.cleangraphql.data

import com.curiousapps.CountriesQuery
import com.curiousapps.CountryQuery
import com.curiousapps.cleangraphql.domain.DetailedCountry
import com.curiousapps.cleangraphql.domain.ListCountries

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry{
    return DetailedCountry(
        code = code,
        name = name,
        capital = capital ?: "No capital",
        emoji = emoji,
        currency = currency ?: "No currency",
        continent = continent.name,
        languages = languages.mapNotNull { it.name }
    )
}fun CountriesQuery.Country.toListCountries(): ListCountries{
    return ListCountries(
        code = code,
        name = name,
        capital = capital ?: "No capital",
        emoji = emoji,
    )
}