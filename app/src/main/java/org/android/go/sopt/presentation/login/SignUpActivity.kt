package org.android.go.sopt.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.model.RequestSignUpDto
import org.android.go.sopt.model.ResponseSignUpDto
import org.android.go.sopt.model.ServicePool.signUpService
import retrofit2.Call
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    // 화면 터치 시 키보드 내리기
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val imm: InputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return super.dispatchTouchEvent(ev)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSignUpBtnClickListner()

        binding.btSignUpDone.setOnClickListener {

            if (
                binding.editId.text.length in 6..10 &&
                binding.editPw.text.length in 8..12 &&
                binding.editNickname.text.isNotBlank() &&
                binding.editIntroduce.text.isNotBlank()
            ) {
                with(binding) {
                    signUpService.signUp(
                        RequestSignUpDto(
                            editId.text.toString(),
                            editPw.text.toString(),
                            editNickname.text.toString(),
                            editIntroduce.text.toString()
                        )
                    ).enqueue(object : retrofit2.Callback<ResponseSignUpDto> {
                        override fun onResponse(
                            call: Call<ResponseSignUpDto>,
                            response: Response<ResponseSignUpDto>,
                        ) {
                            if (response.isSuccessful) {
                                //찐 서버통신 성공
                                startActivity(
                                    Intent(
                                        this@SignUpActivity,
                                        SignUpActivity::class.java
                                    )
                                )
                                Toast.makeText(
                                    this@SignUpActivity, response.body()?.message ?: "회원가입에 성공했습니다",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {//서버통신 실패
                                Toast.makeText(
                                    this@SignUpActivity,
                                    "서버통신 실패 (40X)",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onFailure(call: Call<ResponseSignUpDto>, t: Throwable) {
                            TODO("Not yet implemented")
                        }
                    }
                    )
                }
            }
        }
    }
}
//
//            val id = binding.editId.text.toString()
//            val pw = binding.editPw.text.toString()
//            val nickname = binding.editNickname.text.toString()
//            val tmi = binding.editIntroduce.text.toString()
//
//            // 조건에 따라 분기
//            when {
//                (id.isEmpty()) || (pw.isEmpty()) || (nickname.isEmpty()) || (tmi.isEmpty()) -> {
//                    Snackbar.make(binding.root, "공란이 있습니다.", Snackbar.LENGTH_SHORT).show()
//                }
//                (id.length < 6) || (id.length > 10) -> {
//                    Snackbar.make(binding.root, "아이디는 6~10글자 입니다.", Snackbar.LENGTH_SHORT).show()
//                }
//                (pw.length < 8) || (pw.length > 12) -> {
//                    Snackbar.make(binding.root, "비밀번호는 8~12글자 입니다.", Snackbar.LENGTH_SHORT).show()
//                }
//                else -> {
//                    val intent = Intent(this, MainActivity::class.java)
//                    intent.putExtra("data_id", id)
//                    intent.putExtra("data_pw", pw)
//                    intent.putExtra("data_nickname", nickname)
//                    intent.putExtra("data_tmi", tmi)
//                    setResult(RESULT_OK, intent)
//                    finish() //startActivity(intent) // 얘랑 finish()얘랑 차이점이 머임?
//                }
//            }


//private fun canUserSignIn(): Boolean {
//    return binding.editId.text.length in 6..10 &&
//            binding.editPw.text.length in 8..12 &&
//            binding.editNickname.text.isNotBlank() &&
//            binding.editIntroduce.text.isNotBlank()
//}
//
//private fun setSignUpBtnClickListner() {
//    binding.btSignUpDone.setOnClickListener {
//        if (canUserSignIn()) {
//            with(binding) {
//                signUpService.signUp(
//                    RequestSignUpDto(
//                        editId.text.toString(),
//                        editPw.text.toString(),
//                        editNickname.text.toString(),
//                        editIntroduce.text.toString()
//                    )
//                ).enqueue(object : retrofit2.Callback<ResponseSignUpDto> {
//                    override fun onResponse(
//                        call: Call<ResponseSignUpDto>,
//                        response: Response<ResponseSignUpDto>,
//                    ) {
//                        if (response.isSuccessful) {
//                            //찐 서버통신 성공
//                            startActivity(
//                                Intent(
//                                    this@SignUpActivity,
//                                    SignUpActivity::class.java
//                                )
//                            )
//                            Toast.makeText(
//                                this@SignUpActivity, response.body()?.message ?: "회원가입에 성공했습니다",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        } else {//서버통신 실패
//                            Toast.makeText(
//                                this@SignUpActivity,
//                                "서버통신 실패 (40X)",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    }
//
//                    override fun onFailure(call: Call<ResponseSignUpDto>, t: Throwable) {
//                        TODO("Not yet implemented")
//                    }
//                }
//                )
//            }
//        }
//    }
//}