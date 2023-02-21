package com.rpfcoding.androidgraphqlpractice.domain

interface CountryClient {

    suspend fun getCountries(): List<SimpleCountry>

    suspend fun getCountry(code: String): DetailedCountry?
}