package org.android.go.sopt.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseListUserDto(
    @SerialName("page")
    val page: Int,
    @SerialName("per_page")
    val per_page: String,
    @SerialName("total")
    val total: String,
    @SerialName("total_pages")
    val total_pages: String,
    @SerialName("data")
    val data: ListUserData
) {
    @Serializable
    data class ListUserData(
        @SerialName("id")
        val id: String,
        @SerialName("email")
        val email: String,
        @SerialName("first_name")
        val first_name: String,
        @SerialName("last_name")
        val last_name: String,
        @SerialName("avatar")
        val avatar: String,
    )
}