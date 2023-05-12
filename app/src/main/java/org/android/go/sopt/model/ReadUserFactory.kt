package org.android.go.sopt.model

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ReadUserFactory {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}
object ReadUserServicePool {
    val readUserService = ReadUserFactory.create<ReadUserService>()
}
