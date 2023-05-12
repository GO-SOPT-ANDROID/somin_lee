package org.android.go.sopt.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseListUserDto(
    @SerialName("page")
    val page: Int,
    @SerialName("per_page")
    val per_page: Int,
    @SerialName("total")
    val total: Int,
    @SerialName("total_pages")
    val total_pages: Int,
    @SerialName("data")
    val data: List<UserServerData>,
    @SerialName("support")
    val support: UserSupport
    ) {
    @Serializable
    data class UserServerData(
        @SerialName("id")
        val id: String,
        @SerialName("email")
        val email: String,
        @SerialName("first_name")
        val first_name: String,
        @SerialName("last_name")
        val last_name: String,
        @SerialName("avatar")
        val avatar: String
    )
    @Serializable
    data class UserSupport(
        @SerialName("url")
        val url:String,
        @SerialName("text")
        val text: String
    )
}