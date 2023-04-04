package org.android.go.sopt

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import org.android.go.sopt.SignUpActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding //바인딩 객체 선언 (자동생성됨)
    private lateinit var getResultText:ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 액티비티에서 사용할 바인딩 클래스의 객체화
        setContentView(binding.root) // getRoot 메서드로 레이아웃 최상단 뷰를 액티비티에 표시 합니다
        var answer_id : String? = null
        var answer_pw : String? = null

        //Activity Result에 콜백 등록 (MainActivity.kt)
        getResultText = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                answer_id = result.data?.getStringExtra("data_id")?:"" // 얘는 엘비스 연산자 nullable하다는 뜻 -> 얘만 써
                answer_pw = result.data?.getStringExtra("data_pw")?:"" // !! -> nonNullable하도록 만들어 줌
            }
            else{
                Snackbar.make(binding.root, "회원 정보가 없습니다", Snackbar.LENGTH_SHORT).show()
            }
        } // 여기까지

        // 로그인 버튼 클릭시
        binding.btLogin.setOnClickListener {
            val input_id = binding.editId.text.toString()
            val input_pw = binding.editPw.text.toString()
            // 입력된 정보가 다를 경우
            if (answer_id == null || answer_pw == null){ //->얘네 when으로 바꾸면 더 조음
                Snackbar.make(binding.root, "회원가입을 진행해주세요.", Snackbar.LENGTH_SHORT).show()
            }
            else if (input_id != answer_id || input_pw != answer_pw) {
                Snackbar.make(binding.root, "아이디와 비밀번호를 확인해주세요.", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(binding.root, "로그인 합니다", Snackbar.LENGTH_SHORT).show()
                val intent = Intent(this, SignUpActivity::class.java) // 자기소개로 이동
            }
        }
        // 회원가입 버튼
        binding.btSignUp.setOnClickListener {
            getResultText.launch(
                Intent(
                    this,
                    SignUpActivity::class.java
                )
            ) // this : 현재 화면, SignUpActivity : 전환할 화면)
        }
    }
}

//val nextIntent = Intent(this, SignUpActivity::class.java) // SignUpActivity로 이동
//startActivity(nextIntent)

// 아래 처럼 합쳐서 써도 됨
// startActivity(Intent(this, SignUpActivity::class.java)) // this : 현재 화면, SignUpActivity : 전환할 화면)