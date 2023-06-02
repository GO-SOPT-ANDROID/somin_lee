package org.android.go.sopt.model

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ImageService {
    @Multipart // request Body가 multi-part 형식으로 request 간다는 것을 의미함.
    @POST("upload")
    fun uploadImage(
        @Part file: MultipartBody.Part, // @Part 어노테이션으로 감싸져야하고 (여러개 Part일 땐 @PartMap 사용), 데이터 타입은 MultipartBody.Part
    ): Call<Unit>
}