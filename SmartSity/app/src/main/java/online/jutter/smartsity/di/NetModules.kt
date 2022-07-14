package online.jutter.smartsity.di

import okhttp3.OkHttpClient
import org.koin.core.module.Module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun Module.provideNetModules() {
    single {
        OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
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
            //.baseUrl(BuildConfig.SERVER_URL)
            .build()
    }

//    single {
//        get<Retrofit>().create(Api::class.java)
//    }
//
//    single {
//        ApiService(get())
//    }
}