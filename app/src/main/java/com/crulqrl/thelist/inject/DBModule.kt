package com.crulqrl.thelist.inject


import com.crulqrl.thelist.TheListApp
import com.crulqrl.thelist.data.db.AppDatabase
import com.crulqrl.thelist.data.db.dao.PostDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Singleton
    @Provides
    fun providePostDao(theListApp: TheListApp): PostDao {
        return AppDatabase.getDatabase(theListApp).postDao()
    }
}