package com.mazouri.mvpkotlin.data

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by wangdongdong on 17-5-22.
 */
object GithubServiceFactory {

    private val BASE_URL: String = "https://api.github.com/"

    fun makeStarterService(): GithubService {
        val retrofit = makeRetrofit()
        return retrofit.create(GithubService::class.java)
    }

    private fun makeOkHttpClient(): OkHttpClient {

        //apply函数：调用某对象的apply函数，在函数范围内，可以任意调用该对象的任意方法，并返回该对象
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder().apply {
            networkInterceptors().add(Interceptor { chain ->
                val original = chain.request()
                val request = original
                        .newBuilder()
                        .method(original.method(), original.body())
                        .build()
                chain.proceed(request)
            })
            addInterceptor(interceptor)
        }.build()
    }

    private fun makeRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(createGsonConverter())
                .client(makeOkHttpClient())
                .build()
    }

    private fun createGsonConverter(): GsonConverterFactory {
        val builder = GsonBuilder().serializeNulls()
        return GsonConverterFactory.create(builder.create())
    }
}