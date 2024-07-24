package com.curiousapps.cleangraphql.domain

interface CountryClient {
    suspend fun getCountries(): List<ListCountries>
    suspend fun getCountry(code: String): DetailedCountry?
}