package com.softwaredevelop.toystory.di

import android.content.Context
import androidx.room.Room
import com.softwaredevelop.toystory.data.database.MovieDatabase
import com.softwaredevelop.toystory.data.network.ApiService
import com.softwaredevelop.toystory.utility.ConstValue.BASE_URL
import com.softwaredevelop.toystory.utility.ConstValue.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun createDatabase(@ApplicationContext context: Context): MovieDatabase =
            Room.databaseBuilder(context, MovieDatabase::class.java, DATABASE_NAME).build()


    @Provides
    @Singleton
    fun getMovieSearchDao(db: MovieDatabase) = db.getMovieSearchDao()

    @Provides
    @Singleton
    fun getRetrofit(): ApiService =
            Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)


}