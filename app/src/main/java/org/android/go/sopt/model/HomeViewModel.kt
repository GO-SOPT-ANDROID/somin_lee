package org.android.go.sopt.model

import androidx.lifecycle.ViewModel
import org.android.go.sopt.R

class HomeViewModel : ViewModel() {
    val mockAnimationList = listOf<RecycleData>(
        RecycleData(
            type = 0,
            imgId = R.drawable.sopt_android,
            name = "헤더용",
            detail = "✨ 내가 본 만화 ✨"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.chainsawman,
            name = "체인소맨",
            detail = "포치타 넘 귀여워용"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.cyberpunk_edgerunner,
            name = "사이버펑크 엣지러너",
            detail = "민수들 짱짱"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.jutsu_kaisen0,
            name = "극장판 주술회전 0",
            detail = "동해 바다"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.attack_on_titan,
            name = "진격의 거인",
            detail = "우주 비행사 여우 캐릭터"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.demon_slayer,
            name = "귀멸의 칼날",
            detail = "오사카 유니버셜 스튜디오"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.haikyu,
            name = "하이큐",
            detail = "바나나 먹는 춘식이"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.mononoke,
            name = "모노노케 히메",
            detail = "요코하마 내천 육교 위"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.soul_eater,
            name = "소울이터",
            detail = "동물병원 벽에 걸린 이미지"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.your_name_is,
            name = "너의 이름은",
            detail = "안드 과제 중"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.doctor_stone,
            name = "너의 이름은",
            detail = "안드 과제 중"
        ),
        RecycleData(
            type = 1,
            imgId = R.drawable.reborn,
            name = "가정교사 히트맨 리본",
            detail = "동물병원 벽에 걸린 이미지"
        )
    )
}