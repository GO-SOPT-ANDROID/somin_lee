package org.android.go.sopt

import android.annotation.SuppressLint // 노란 거 뜨길래 alt enter로 추가 했는데 얘 뭐임?
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.android.go.sopt.databinding.ActivityIntroduceBinding

class IntroduceActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduce)
        val binding = ActivityIntroduceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resultNickname.text = (intent.getStringExtra("data_nickname")+"의 한 마디")
        binding.resultTmi.text = "\"${intent.getStringExtra("data_tmi")}\""
    }
}