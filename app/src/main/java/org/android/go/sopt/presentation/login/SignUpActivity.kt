package org.android.go.sopt.presentation.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.model.signup.SignUpViewModel

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val viewModel by viewModels<SignUpViewModel>()

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
        signUpByViewModel()
        initSignUpButton()
    }

    private fun signUpByViewModel() {
        viewModel.idInputValid.observe(this, Observer { isValid ->
            if (isValid) {
                binding.editSignupId.error = null
            } else {
                binding.editSignupId.error = "ID는 알파벳과 숫자를 포함한 6~10글자 입니다."
            }
        })
        viewModel.pwInputValid.observe(this, Observer { isValid ->
            if (isValid) {
                binding.editSignupPw.error = null
            } else {
                binding.editSignupPw.error = "비밀번호는 알파벳과 숫자, 특수문자를 포함한 6~12글자 입니다."
            }
        })

        binding.editSignupIdText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val input = s.toString()
                viewModel.checkId(input)
                viewModel.onTextChanged()
                binding.btSignUpDone.isEnabled = viewModel.isButtonEnabled.value!!
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.editSignupPwText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val input = s.toString()
                viewModel.checkPw(input)
                viewModel.onTextChanged()
                binding.btSignUpDone.isEnabled = viewModel.isButtonEnabled.value!!
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun initSignUpButton() = with(binding) {
        btSignUpDone.setOnClickListener {
            if (btSignUpDone.isEnabled) {
                viewModel.signUp(
                    editSignupIdText.text.toString(),
                    editSignupPwText.text.toString(),
                    editSignupNicknameText.text.toString(),
                    editSignupIntroduceText.text.toString()
                )
                moveToLogin()
            }
        }
    }

    private fun moveToLogin() {
        val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
        finish()
        startActivity(intent)
    }
}