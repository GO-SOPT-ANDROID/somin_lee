package org.android.go.sopt.model
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

/**recycler view에 들어갈 클래스*/
@Parcelize
data class SomData(
    // 밑에 이상한 녀석이 있죠? 이는 안드로이드의 Meta Annotation입니다.
    @DrawableRes
    val image: Int, // 서버에서 이미지 url이 내려오는 경우 String으로 받아야합니다. (Json 내부에는 URL 타입은 들어갈 수 없음)
    val name: String,
    val detail: String
) : Parcelable