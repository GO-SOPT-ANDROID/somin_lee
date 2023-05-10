package org.android.go.sopt.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UserData(
    // 밑에 이상한 녀석이 있죠? 이는 안드로이드의 Meta Annotation입니다.
    val id: String?, // 서버에서 이미지 url이 내려오는 경우 String으로 받아야합니다. (Json 내부에는 URL 타입은 들어갈 수 없음)
//    val pw: String?,
    val nickname: String?,
    val intro: String?
) : Parcelable