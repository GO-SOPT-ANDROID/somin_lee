package org.android.go.sopt.model

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.android.go.sopt.BuildConfig
//import org.android.go.sopt.interceptor.SoptInterceptor
import org.android.go.sopt.model.signup.SignUpService
import org.android.go.sopt.model.user.ReadUserService
import retrofit2.Retrofit

object ApiFactory {
    private const val SOPT_BASE_URL = BuildConfig.SOPT_BASE_URL
    private const val REQRES_BASE_URL = BuildConfig.REQRES_BASE_URL

    val signUpRetrofit: SignUpService by lazy {
        Retrofit.Builder()
            .baseUrl(SOPT_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(SignUpService::class.java)
    }

    val readUserRetrofit: ReadUserService by lazy {
        Retrofit.Builder()
            .baseUrl(REQRES_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(ReadUserService::class.java)
    }


    val retrofitForImage: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(REQRES_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofitForImage.create<T>(T::class.java)

    object ServicePool {
        val imageService = ApiFactory.create<ImageService>()
    }

//    private val client by lazy {
//        OkHttpClient.Builder().addInterceptor(SoptInterceptor())
//            .addInterceptor(
//                HttpLoggingInterceptor().apply { {
//            level =
//                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
//        }).build()
//    }
//    val retrofitForAuth: Retrofit by lazy {
//        Retrofit.Builder().baseUrl(BuildConfig.SOPT_BASE_URL)
//            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
//            .client(client).build()
//    }
//        inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}