package org.android.go.sopt.login


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivityLoginBinding
import org.android.go.sopt.extension.snackbarShort
import org.android.go.sopt.model.UserData

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding //바인딩 객체 선언 (자동생성됨)
    private lateinit var signUpLauncher: ActivityResultLauncher<Intent>
    var userData: UserData? = null
    private var inputId: String? = null
    private var inputPw: String? = null

    // 화면 터치 시 키보드 내리기
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean { // 얘 따로 빼고 싶어
//        hideKeyboard()
        val imm: InputMethodManager? = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return super.dispatchTouchEvent(ev)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater) // 액티비티에서 사용할 바인딩 클래스의 객체화
        setContentView(binding.root) // getRoot 메서드로 레이아웃 최상단 뷰를 액티비티에 표시 합니다
        initView()
    }

    private fun initView() = with(binding) {
        signUpLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    userData = when {
                        (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) -> {
                            result.data?.getParcelableExtra("user_data", UserData::class.java)
                        }
                        else -> {
                            result.data?.getParcelableExtra<UserData>("user_data")
                        }
                    }
                } else {
                    root.snackbarShort("회원 정보가 없습니다")
                }
            }
        btLogin.setOnClickListener() {
            login()
        }
        btSignUp.setOnClickListener() {
            signUp()
        }
    }

    /**로그인 버튼 유저 정보가 없으면 회원 가입 스낵바, 입력 값이 없으면 입력 스낵바, 값이 다르면 재입력 스낵바, 같으면 Introduce Activity로 이동*/
    private fun login() = with(binding) {
        inputId = editId.text.toString()
        inputPw = editPw.text.toString()
        when {
            (inputId != userData?.id || inputPw != userData?.pw) -> {
                root.snackbarShort("아이디와 비밀번호를 확인해주세요.")
            }
            else -> {
                root.snackbarShort("로그인 합니다")
                var intent = Intent(this@LoginActivity, IntroduceActivity::class.java)
                intent.putExtra("user_data", userData)
                setResult(RESULT_OK, intent)
                finish()
                startActivity(intent)
            }
        }
    }

    private fun signUp() {
        signUpLauncher.launch(Intent(this, SignUpActivity::class.java))
    }
}