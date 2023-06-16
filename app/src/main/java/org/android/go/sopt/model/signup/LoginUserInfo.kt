package org.android.go.sopt.model.signup

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class LoginUserInfo(
    val id: String?, // 서버에서 이미지 url이 내려오는 경우 String으로 받아야합니다. (Json 내부에는 URL 타입은 들어갈 수 없음)
    val nickname: String?,
    val intro: String?
) : Parcelable