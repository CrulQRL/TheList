package com.crulqrl.thelist.inject

import com.crulqrl.thelist.data.api.PostApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    fun providesRetrofitBuilder(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Provides
    fun providesPostAPI(
        retrofitBuilder: Retrofit.Builder
    ): PostApi {
        return retrofitBuilder.build().create(PostApi::class.java)
    }

}