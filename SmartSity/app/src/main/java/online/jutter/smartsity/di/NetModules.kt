package online.jutter.smartsity.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import online.jutter.smartsity.BuildConfig
import online.jutter.smartsity.data.net.retrofit.Api
import online.jutter.smartsity.data.net.retrofit.ApiLogger
import online.jutter.smartsity.data.net.retrofit.ApiService
import org.koin.core.module.Module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun Module.provideNetModules() {
    single {
        OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .also {
                //if (BuildConfig.DEBUG) {
                    it.addInterceptor(
                        HttpLoggingInterceptor(ApiLogger())
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
                //}
            }
            //.addInterceptor(HeadersInterceptor(androidContext()))
            .build()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
    }

    single {
        get<Retrofit.Builder>()
            .baseUrl(BuildConfig.SERVER_URL)
            .build()
    }

    single {
        get<Retrofit>().create(Api::class.java)
    }

    single {
        ApiService(get())
    }
}
