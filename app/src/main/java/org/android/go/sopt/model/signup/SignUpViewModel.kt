package org.android.go.sopt.model.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.android.go.sopt.extension.makeToastMessage
import org.android.go.sopt.util.ApiFactory
import org.android.go.sopt.util.ApiFactory.signUpRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel() {

    private val _idInputValid = MutableLiveData<Boolean>()
    val idInputValid: LiveData<Boolean> = _idInputValid

    private val _pwInputValid = MutableLiveData<Boolean>()
    val pwInputValid: LiveData<Boolean> = _pwInputValid

    private val _isButtonEnabled = MutableLiveData<Boolean>()
    val isButtonEnabled: LiveData<Boolean> = _isButtonEnabled

    private val idPattern = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,10}$") // 정규 표현식 객체
    private val pwPattern =
        Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{6,12}$")

    init {
        _isButtonEnabled.value = false
    }

    fun checkId(id: String) {
        _idInputValid.value = idPattern.matches(id)
        Log.d("회원가입 id", _idInputValid.value.toString())
    }

    fun checkPw(pw: String) {
        _pwInputValid.value = pwPattern.matches(pw)
        Log.d("회원가입 pw", _pwInputValid.value.toString())
    }

    fun checkName(pw: String) {
        _pwInputValid.value = pwPattern.matches(pw)
        Log.d("회원가입 pw", _pwInputValid.value.toString())
    }

    fun onTextChanged() {
        _isButtonEnabled.value = (idInputValid.value == true && pwInputValid.value == true)
        Log.d("회원가입 확인", _isButtonEnabled.value.toString())
    }

    fun signUp(id: String, pw: String, name: String, skill: String) {
        signUpRetrofit.signUp(
            RequestSignUpDto(
                id, pw, name, skill
            )
        ).enqueue(object : Callback<ResponseSignUpDto> {
            override fun onResponse(
                call: Call<ResponseSignUpDto>,
                response: Response<ResponseSignUpDto>
            ) {
                if (response.body()?.status == 200 && response.isSuccessful) {
                    Log.e("회원가입 뷰모델", "회원가입 성공")
                } else {
                    Log.e("회원가입 뷰모델", "입력값 오류")
                }
            }

            override fun onFailure(call: Call<ResponseSignUpDto>, t: Throwable) {
                Log.e("회원가입 뷰모델", "서버 오류")
            }

        })
    }
}