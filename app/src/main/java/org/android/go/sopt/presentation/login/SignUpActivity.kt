package org.android.go.sopt.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.extension.makeSnackbar
import org.android.go.sopt.extension.makeToastMessage
import org.android.go.sopt.model.ApiFactory.signUpRetrofit
import org.android.go.sopt.model.signup.RequestSignUpDto
import org.android.go.sopt.model.signup.ResponseSignUpDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    // 화면 터치 시 키보드 내리기
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return super.dispatchTouchEvent(ev)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        initView()
    }

    private fun initView() = with(binding) {
        setContentView(root)
        btSignUpDone.setOnClickListener {
            doSignUp()
        }
    }

    private fun doSignUp() = with(binding) {
        val inputId = editSignupId.text.toString()
        val inputPw = editSignupPw.text.toString()
        val inputNickname = editSignupNickname.text.toString()
        val inputIntro = editSignupIntroduce.text.toString()

        when {
            (inputId.isEmpty()) || (inputPw.isEmpty()) || (inputNickname.isEmpty()) || (inputIntro.isEmpty()) -> {
                binding.root.makeSnackbar("공란이 있습니다.")
            }
            (inputId.length < 6) || (inputId.length > 10) -> {
                binding.root.makeSnackbar("아이디는 6~10글자 입니다.")
            }
            (inputPw.length < 8) || (inputPw.length > 12) -> {
                binding.root.makeSnackbar("비밀번호는 8~12글자 입니다.")
            }
            else -> {
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                setResult(RESULT_OK, intent)
                completeSignUp()
            }
        }
    }
    /**서버통신 로직*/
    private fun completeSignUp() { //회원가입에 필요한 정보 입력

        // service 객체 생성
        val signUpService =
            signUpRetrofit //Retrofit으로 생성된 서비스 인터페이스를 사용하여 HTTP 요청을 보낼 수 있는 객체

        // call 객체 생성
        val signUpCall = signUpService.signUp(with(binding) {
            RequestSignUpDto( //회원가입 정보 객체
                editSignupId.text.toString(),
                editSignupPw.text.toString(),
                editSignupNickname.text.toString(),
                editSignupIntroduce.text.toString()
            )
        })
        // 네트워크 통신
        signUpCall.enqueue(object : Callback<ResponseSignUpDto>{
            override fun onResponse(
                call: Call<ResponseSignUpDto>,
                response: Response<ResponseSignUpDto>
            ) {
                if (response.isSuccessful && response.body()?.status==200) {
                    response.body()?.message?.let { makeToastMessage(it) } ?: "회원가입에 성공했습니다."
                    if (!isFinishing) finish() // 현재 액티비티 종료
                } else {
                    // 실패한 응답
                    response.body()?.message?.let { makeToastMessage(it) } ?: "회원가입에 실패했습니다."
                    makeToastMessage("중복된 아이디입니다.")
                }
            }
            override fun onFailure(call: Call<ResponseSignUpDto>, t: Throwable) {
                makeToastMessage("서버 통신에 실패했습니다.")
            }

        })
//        signUpService.signUp(
//            with(binding) {
//                RequestSignUpDto( //회원가입 정보 객체
//                    editSignupId.text.toString(),
//                    editSignupPw.text.toString(),
//                    editSignupNickname.text.toString(),
//                    editSignupIntroduce.text.toString()
//                )
//            }
//        ).enqueue(object : retrofit2.Callback<ResponseSignUpDto> {
//            override fun onResponse(
//                // onResponse : 서버 응답이 성공적으로 도착했을 때 호출
//                call: Call<ResponseSignUpDto>,
//                response: Response<ResponseSignUpDto>,
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.message?.let { makeToastMessage(it) } ?: "회원가입에 성공했습니다."
//                    if (!isFinishing) finish() // 현재 액티비티 종료
//                } else {
//                    // 실패한 응답
//                    response.body()?.message?.let { makeToastMessage(it) } ?: "서버통신 실패(40X)"
//                }
//            }
//            override fun onFailure(call: Call<ResponseSignUpDto>, t: Throwable) {
//                // 통신 실패 시 예외 객체(Throwable)에서 실패 원인을 가져와 처리
//                t.message?.let { binding.root.makeSnackbar(it) } ?: "서버통신 실패(응답값 X)"
//            }
//        })
    }
}