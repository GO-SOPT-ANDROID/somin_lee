package org.android.go.sopt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.MainActivity
import org.android.go.sopt.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSignUpDone.setOnClickListener{
            val id = binding.editId.text.toString()
            val pw = binding.editPw.text.toString()
            val nickname = binding.editNickname.text.toString()

            // 유저가 항목을 다 채우지 않았을 경우
            if(id.isEmpty() || pw.isEmpty() || nickname.isEmpty()){
                Snackbar.make(binding.root,"공란이 있습니다.",Snackbar.LENGTH_SHORT).show()
            }
            else if(id.length<6 || id.length>10){
                Snackbar.make(binding.root,"아이디는 6~10글자 입니다.",Snackbar.LENGTH_SHORT).show()
            }
            else if(pw.length<8 || pw.length>12){
                Snackbar.make(binding.root,"비밀번호는 8~12글자 입니다.",Snackbar.LENGTH_SHORT).show()
            }
            else {
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("data_id", id)
                intent.putExtra("data_pw", pw)
                intent.putExtra("data_nickname", nickname)

                setResult(RESULT_OK,intent)
                finish() //startActivity(intent) // 얘랑 finish()얘랑 차이점이 머임?

//              intent.putExtra("data_id", binding.editId.text.toString())
//              intent.putExtra("data_pw", binding.editPw.text.toString())
//              intent.putExtra("data_nickname", binding.editNickname.text.toString())
            }
        }
    }
}