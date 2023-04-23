package org.android.go.sopt.model

import androidx.lifecycle.ViewModel
import org.android.go.sopt.R

class HomeViewModel : ViewModel() {
    val mockSomList = listOf<SomData>(
        SomData(
            type = 0,
            imgId = R.drawable.sopt_android,
            name = "minsoi",
            detail = "✨ 터벅터벅 걸어가는 소민의 일상 ✨"
        ),
        SomData(
            type = 1,
            imgId = R.drawable.sopt_android,
            name = "Go SOPT 32 ANDROID!",
            detail = "민수들 짱짱"
        ),
        SomData(
            type = 1,
            imgId = R.drawable.som2,
            name = "강릉 가족 여행",
            detail = "동해 바다"
        ),
        SomData(
            type = 1,
            imgId = R.drawable.minsoi,
            name = "유니",
            detail = "우주 비행사 여우 캐릭터"
        ),
        SomData(
            type = 1,
            imgId = R.drawable.som1,
            name = "일본 여행",
            detail = "오사카 유니버셜 스튜디오"
        ),
        SomData(
            type = 1,
            imgId = R.drawable.som3,
            name = "춘식이",
            detail = "바나나 먹는 춘식이"
        ),
        SomData(
            type = 1,
            imgId = R.drawable.som4,
            name = "일본 여행",
            detail = "요코하마 내천 육교 위"
        ),
        SomData(
            type = 1,
            imgId = R.drawable.som5,
            name = "썬글라스 요크셔테리어",
            detail = "동물병원 벽에 걸린 이미지"
        ),
        SomData(
            type = 1,
            imgId = R.drawable.som6,
            name = "내 방",
            detail = "안드 과제 중"
        ),
        SomData(
            type = 1,
            imgId = R.drawable.som7,
            name = "암멍이",
            detail = "포켓몬스터 썬앤문에 등장하는 포켓몬"
        )
    )
}