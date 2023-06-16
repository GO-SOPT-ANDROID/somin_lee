package org.android.go.sopt.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.android.go.sopt.util.ApiFactory.ServicePool.imageService
import org.android.go.sopt.util.ContentUriRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    private val _image = MutableLiveData<ContentUriRequestBody>()
    private val image: LiveData<ContentUriRequestBody>
        get() = _image

    fun setRequestBody(requestBody: ContentUriRequestBody) {
        _image.value = requestBody
    }

    fun uploadImage() {
        if (image.value != null) {
            imageService.uploadImage(image.value!!.toFormData()).enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    if (response.isSuccessful) {
                        Log.e("sopt", "image upload success")
                    }
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        } else {
            // TODO: 서버 통신 실패시 로직 구현
        }
        imageService.uploadImage(image.value!!.toFormData())
    }
}