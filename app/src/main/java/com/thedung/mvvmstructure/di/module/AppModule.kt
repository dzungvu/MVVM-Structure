package com.thedung.mvvmstructure.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.thedung.mvvmstructure.application.AppConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder().disableHtmlEscaping().create()
    }

    @Provides
    @Singleton
    fun providesAppConfig(@ApplicationContext context: Context) = AppConfig(context)

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context
}