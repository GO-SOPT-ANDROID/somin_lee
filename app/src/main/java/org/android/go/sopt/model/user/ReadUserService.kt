package org.android.go.sopt.model.user

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReadUserService {
    @GET("api/users")
    fun readUsers(
        @Query("page") page : Int
    ): Call<ResponseUserDto>
}