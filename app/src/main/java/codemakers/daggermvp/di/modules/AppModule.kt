package codemakers.daggermvp.di.modules

import android.app.Activity
import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import codemakers.daggermvp.data.AppDatabase
import codemakers.daggermvp.data.dao.TodoDao
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun providePreference(context: Context): SharedPreferences
            = context.getSharedPreferences("TodoPreference", Activity.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase
            = Room.databaseBuilder(context, AppDatabase::class.java, "todo.db")
            .build()

    @Singleton
    @Provides
    fun provideTodoDao(appDatabase: AppDatabase): TodoDao
            = appDatabase.todoDao()


}