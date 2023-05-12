package org.android.go.sopt.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val imgUrl: String,
    val name: String,
    val email: String
) : Parcelable