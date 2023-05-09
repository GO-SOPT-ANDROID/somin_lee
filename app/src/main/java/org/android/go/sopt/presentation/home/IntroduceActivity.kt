package org.android.go.sopt.presentation.home

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.android.go.sopt.databinding.ActivityIntroduceBinding
import org.android.go.sopt.model.UserData

class IntroduceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroduceBinding //바인딩 객체 선언 (자동생성됨)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroduceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() = with(binding) {
        val userData = when {
            (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) -> {
                intent.getParcelableExtra("user_data", UserData::class.java)
            }
            else -> {
                intent.getParcelableExtra<UserData>("user_data")
            }
        }
        val userIntro = "${userData?.nickname}의 한 마디"
        val introMessage = "${userData?.tmi}"
        resultNickname.text = userIntro
        resultTmi.text = introMessage
    }
}