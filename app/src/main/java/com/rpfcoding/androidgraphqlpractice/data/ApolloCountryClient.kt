package com.rpfcoding.androidgraphqlpractice.data

import com.apollographql.apollo3.ApolloClient
import com.rpfcoding.CountriesQuery
import com.rpfcoding.CountryQuery
import com.rpfcoding.androidgraphqlpractice.domain.CountryClient
import com.rpfcoding.androidgraphqlpractice.domain.DetailedCountry
import com.rpfcoding.androidgraphqlpractice.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data?.countries?.map {
                SimpleCountry(
                    name = it.name,
                    capital = it.capital ?: "N/A",
                    code = it.code,
                    emoji = it.emoji
                )
            } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data?.country?.let { country ->
                DetailedCountry(
                    name = country.name,
                    capital = country.capital ?: "N/A",
                    code = country.code,
                    emoji = country.emoji,
                    currency = country.currency ?: "N/A",
                    languages = country.languages.mapNotNull { it.name },
                    continent = country.continent.name
                )
            }
    }
}