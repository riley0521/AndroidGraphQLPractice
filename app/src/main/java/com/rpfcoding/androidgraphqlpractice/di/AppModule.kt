package com.rpfcoding.androidgraphqlpractice.di

import com.apollographql.apollo3.ApolloClient
import com.rpfcoding.androidgraphqlpractice.data.ApolloCountryClient
import com.rpfcoding.androidgraphqlpractice.domain.CountryClient
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
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(
        client: ApolloClient
    ): CountryClient {
        return ApolloCountryClient(client)
    }
}