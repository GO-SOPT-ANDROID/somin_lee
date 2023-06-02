package org.android.go.sopt.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivityLoginBinding
import org.android.go.sopt.extension.makeSnackbar
import org.android.go.sopt.extension.makeToastMessage
import org.android.go.sopt.model.*
import org.android.go.sopt.model.ApiFactory.signUpRetrofit
import org.android.go.sopt.model.signup.RequestSignInDto
import org.android.go.sopt.model.signup.ResponseSignInDto
import org.android.go.sopt.presentation.login.viewmodel.SignInViewModel
import org.android.go.sopt.presentation.main.MainActivity
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding //바인딩 객체 선언 (자동생성됨)

    private val viewModel by viewModels<SignInViewModel>() // 라이브 데이터 사용을 위한 뷰모델

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
//            login()
            loginByViewModel()
        }
        btMoveSignUp.setOnClickListener() {
            signUp()
        }
    }

    private fun loginByViewModel(){
        viewModel.signIn(
            binding.editLoginId.text.toString(),
            binding.editLoginPw.text.toString()
        )

        viewModel.signInResult.observe(this) { signInResult ->
            startActivity(
                Intent(
                    this@LoginActivity,
                    MainActivity::class.java
                )
            )
            moveToHome(
                signInResult.data
            )

            println("%s 이랍니다?".format(signInResult.data))
            makeToastMessage(
                signInResult.message
            )
        }
    }

    private fun moveToHome(loginData: ResponseSignInDto.SignInData?) {
        saveData(loginData)
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        finish()
        startActivity(intent)
    }

    /**로그인 버튼 유저 정보가 없으면 회원 가입 스낵바, 입력 값이 없으면 입력 스낵바, 값이 다르면 재입력 스낵바, 같으면 Introduce Activity로 이동*/
    private fun saveData(loginUserInfo: ResponseSignInDto.SignInData?) {
        val autoLogin = getSharedPreferences("AutoLogin", Context.MODE_PRIVATE)
        val autoLoginEdit = autoLogin.edit()
        autoLoginEdit.putString("KEY_ID", loginUserInfo?.id)
        autoLoginEdit.putString("KEY_NICKNAME", loginUserInfo?.name)
        autoLoginEdit.putString("KEY_INTRO", loginUserInfo?.skill)
        autoLoginEdit.apply()
    }

    private fun signUp() {
        startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
    }
}