package org.android.go.sopt.model.signup

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("sign-up")
    fun signUp(
        @Body request: RequestSignUpDto,
    ): Call<ResponseSignUpDto>

    @POST("sign-in")
    fun signIn(
        @Body request: RequestSignInDto,
    ): Call<ResponseSignInDto>
}