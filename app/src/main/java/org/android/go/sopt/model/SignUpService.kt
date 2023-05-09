package org.android.go.sopt.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("sign-up")
    fun signUp(
        @Body request: RequestSignUpDto,
    ): Call<ResponseSignUpDto>
}