package org.android.go.sopt.model.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.android.go.sopt.util.ApiFactory.signUpRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() { // 로그인 시 결과값을 받아옴

    private val _signInResult: MutableLiveData<ResponseSignInDto> = MutableLiveData()
    val signInResult: MutableLiveData<ResponseSignInDto> = _signInResult

    fun login(id: String, password: String) {
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
                if (response.body()?.status == 200 && response.isSuccessful) {
                    signInResult.value = response.body() // 뮤터블 데이터의 value에 응답 body를 넣어줌
                } else {
                    Log.e("로그인 뷰모델", "입력값 오류")
                }
            }

            override fun onFailure(call: Call<ResponseSignInDto>, t: Throwable) {
                Log.e("로그인 뷰모델", "서버 오류")
            }
        })
    }
}