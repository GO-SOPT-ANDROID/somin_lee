package org.android.go.sopt.presentation.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.android.go.sopt.model.ApiFactory.signUpRetrofit
import org.android.go.sopt.model.signup.RequestSignInDto
import org.android.go.sopt.model.signup.ResponseSignInDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInViewModel : ViewModel() { // 로그인 시 결과값을 받아옴

    private val _signInResult : MutableLiveData<ResponseSignInDto> = MutableLiveData()
    val signInResult: MutableLiveData<ResponseSignInDto> get() = _signInResult

    fun signIn(id: String, password: String) {
        signUpRetrofit.login(
            RequestSignInDto(
                id,
                password
            )
        ).enqueue(object : Callback<ResponseSignInDto> {
            override fun onResponse(
                call: Call<ResponseSignInDto>,
                response: Response<ResponseSignInDto>,
            ) {
                if (response.isSuccessful) {
                    signInResult.value = response.body() // 뮤터블 데이터의 value에 응답 body를 넣어줌
                } else {
                    // TODO: 에러 처리
                }
            }

            override fun onFailure(call: Call<ResponseSignInDto>, t: Throwable) {
                // TODO: 에러 처리
            }
        })
    }
}