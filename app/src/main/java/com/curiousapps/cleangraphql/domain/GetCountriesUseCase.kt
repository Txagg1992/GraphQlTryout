package com.curiousapps.cleangraphql.domain

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(): List<ListCountries>{
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}