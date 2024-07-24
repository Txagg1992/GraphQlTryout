package com.curiousapps.cleangraphql.di

import com.apollographql.apollo3.ApolloClient
import com.curiousapps.cleangraphql.data.ApolloCountryClient
import com.curiousapps.cleangraphql.domain.CountryClient
import com.curiousapps.cleangraphql.domain.GetCountriesUseCase
import com.curiousapps.cleangraphql.domain.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient{
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient{
        return ApolloCountryClient(apolloClient)
    }
    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient): GetCountriesUseCase{
        return GetCountriesUseCase(countryClient)
    }
    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient): GetCountryUseCase{
        return GetCountryUseCase(countryClient)
    }

}