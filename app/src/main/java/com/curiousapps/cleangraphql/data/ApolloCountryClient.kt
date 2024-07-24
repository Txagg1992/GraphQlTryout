package com.curiousapps.cleangraphql.data

import com.apollographql.apollo3.ApolloClient
import com.curiousapps.CountriesQuery
import com.curiousapps.CountryQuery
import com.curiousapps.cleangraphql.domain.CountryClient
import com.curiousapps.cleangraphql.domain.DetailedCountry
import com.curiousapps.cleangraphql.domain.ListCountries

class ApolloCountryClient(
    private val apolloClient: ApolloClient
): CountryClient {
    override suspend fun getCountries(): List<ListCountries> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toListCountries() } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}