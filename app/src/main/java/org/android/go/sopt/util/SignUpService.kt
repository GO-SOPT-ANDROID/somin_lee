package org.android.go.sopt.util

import org.android.go.sopt.model.signup.RequestSignInDto
import org.android.go.sopt.model.signup.RequestSignUpDto
import org.android.go.sopt.model.signup.ResponseSignInDto
import org.android.go.sopt.model.signup.ResponseSignUpDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("sign-up")
    fun signUp(
        @Body request: RequestSignUpDto,
    ): Call<ResponseSignUpDto>

    @POST("sign-in")
    fun login(
        @Body request: RequestSignInDto,
    ): Call<ResponseSignInDto>
}