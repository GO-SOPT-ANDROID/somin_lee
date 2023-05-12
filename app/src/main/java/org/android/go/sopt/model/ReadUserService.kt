package org.android.go.sopt.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReadUserService {
    @GET("api/users")
    fun roadUsers(
        @Query("page") page : Int
    ): Call<ResponseListUserDto>
}