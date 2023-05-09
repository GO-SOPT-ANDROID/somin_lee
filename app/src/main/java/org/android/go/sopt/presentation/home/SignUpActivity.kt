package org.android.go.sopt.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.model.UserData
import org.android.go.sopt.extension.snackbarShort
import org.android.go.sopt.presentation.login.LoginActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding

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
        btSignUpDone.setOnClickListener{
            DoSignUp()
        }
    }
    private fun DoSignUp() = with(binding){
        val userData = UserData(editId.text.toString(), editPw.text.toString(), editNickname.text.toString(), editIntroduce.text.toString())
        when{
            (userData.id.isEmpty()) || (userData.pw.isEmpty()) || (userData.nickname.isEmpty()) || (userData.intro.isEmpty())->{
                binding.root.snackbarShort("공란이 있습니다.")
            }
            (userData.id.length<6) || (userData.id.length>10)->{
                binding.root.snackbarShort("아이디는 6~10글자 입니다.")
            }
            (userData.pw.length<8) || (userData.pw.length>12)->{
                binding.root.snackbarShort("비밀번호는 8~12글자 입니다.")
            }
            else-> {
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                intent.putExtra("user_data",userData)
                Log.d("singUp Activity", userData.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}