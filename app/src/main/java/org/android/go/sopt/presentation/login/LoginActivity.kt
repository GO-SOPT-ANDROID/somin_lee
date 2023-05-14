package org.android.go.sopt.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivityLoginBinding
import org.android.go.sopt.extension.makeSnackbar
import org.android.go.sopt.extension.makeToastMessage
import org.android.go.sopt.model.*
import org.android.go.sopt.model.ApiFactory.signUpRetrofit
import org.android.go.sopt.model.signup.RequestSignInDto
import org.android.go.sopt.model.signup.ResponseSignInDto
import org.android.go.sopt.presentation.main.MainActivity
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding //바인딩 객체 선언 (자동생성됨)

    // 화면 터치 시 키보드 내리기
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean { // 얘 따로 빼고 싶어
        val imm: InputMethodManager? = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return super.dispatchTouchEvent(ev)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater) // 액티비티에서 사용할 바인딩 클래스의 객체화
        initView()
    }

    private fun initView() = with(binding) {
        setContentView(root) // getRoot 메서드로 레이아웃 최상단 뷰를 액티비티에 표시
        btLogin.setOnClickListener() {
            login()
        }
        btMoveSignUp.setOnClickListener() {
            signUp()
        }
    }



    private fun login() = with(binding) {
        val loginService = signUpRetrofit

        loginService.signIn(with(binding) {
            RequestSignInDto(
                editLoginId.text.toString(), editLoginPw.text.toString()
            )
        }).enqueue(object : retrofit2.Callback<ResponseSignInDto> {
            override fun onResponse(
                call: Call<ResponseSignInDto>,
                response: Response<ResponseSignInDto>,
            ) {
                if (response.code() == 200) {
                    makeToastMessage("${editLoginId.text}님, 환영합니다.")
                    val loginData = LoginUserInfo(
                        response.body()?.data?.id,
                        response.body()?.data?.name,
                        response.body()?.data?.skill,
                    )
                    moveToHome(loginData)
                } else if (response.code() == 400) {
                    makeToastMessage("아이디와 비밀번호를 확인해주세요.")
                } else {
                    makeToastMessage("응답값이 없습니다.")
                }
            }

            override fun onFailure(call: Call<ResponseSignInDto>, t: Throwable) {
                // 통신 실패 시 예외 객체(Throwable)에서 실패 원인을 가져와 처리
                Log.d("로그인 실패", "${t.message}")
                t.message?.let { binding.root.makeSnackbar(it) } ?: "서버통신 실패(응답값 X)"
            }
        })
    }

    private fun moveToHome(loginData: LoginUserInfo) {
        saveData(loginData)
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        finish()
        startActivity(intent)
    }


    /**로그인 버튼 유저 정보가 없으면 회원 가입 스낵바, 입력 값이 없으면 입력 스낵바, 값이 다르면 재입력 스낵바, 같으면 Introduce Activity로 이동*/
    private fun saveData(loginUserInfo: LoginUserInfo?) {
        val autoLogin = getSharedPreferences("AutoLogin", Context.MODE_PRIVATE)
        val autoLoginEdit = autoLogin.edit()
        autoLoginEdit.putString("KEY_ID", loginUserInfo?.id)
        autoLoginEdit.putString("KEY_NICKNAME", loginUserInfo?.nickname)
        autoLoginEdit.putString("KEY_INTRO", loginUserInfo?.intro)
        autoLoginEdit.apply()
    }

    private fun signUp() {
        startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
    }
}