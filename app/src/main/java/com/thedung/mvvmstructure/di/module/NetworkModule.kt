package com.thedung.mvvmstructure.di.module

import com.google.gson.Gson
import com.thedung.mvvmstructure.BuildConfig
import com.thedung.mvvmstructure.classes.adapters.NetworkResponseAdapterFactory
import com.thedung.mvvmstructure.services.CharacterServices
import com.thedung.mvvmstructure.services.MainService
import com.thedung.mvvmstructure.utils.debug
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    private const val CONNECTION_TIMEOUT = 30_000L
    private const val READ_TIMEOUT = 30_000L

    init {
        System.loadLibrary("app-values")
    }


    private external fun getBaseUrl(debug: Boolean): String

    private fun getBaseUrl(): String {
        return getBaseUrl(BuildConfig.DEBUG)
    }

    private external fun getPublicKeyFromEx(): String
    private fun getPublicKey(): String {
        return getPublicKeyFromEx()
    }

    private external fun getPrivateKeyFromEx(): String
    private fun getPrivateKey(): String {
        return getPrivateKeyFromEx()
    }

    @Provides
    fun providesInterceptor() = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .url(chain.request().url)
            .build()
        return@Interceptor chain.proceed(request)
    }

    private fun createHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient =
            OkHttpClient.Builder()
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
        httpClient.addInterceptor(interceptor)
        debug {
            httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        return httpClient.build()
    }

    @Provides
    fun providesClient(
        interceptor: Interceptor,
        gson: Gson,
        adapterFactory: NetworkResponseAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .client(createHttpClient(interceptor))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(adapterFactory)
            .build()
    }

    @Provides
    @Reusable
    fun providesMainService(retrofit: Retrofit): MainService =
        retrofit.create(MainService::class.java)

    @Provides
    @Reusable
    fun providesCharacterService(retrofit: Retrofit): CharacterServices =
        retrofit.create(CharacterServices::class.java)
}