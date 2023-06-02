package org.android.go.sopt.model.user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.android.go.sopt.util.ApiFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {
    private val _userList = MutableLiveData<List<ResponseUserDto.Data>?>()
    val userList: LiveData<List<ResponseUserDto.Data>?> = _userList

    fun initView() {
        ApiFactory.readUserRetrofit.readUsers(1).enqueue(object : Callback<ResponseUserDto> {
            override fun onResponse(
                call: Call<ResponseUserDto>, response: Response<ResponseUserDto>
            ) {
                if (response.isSuccessful) {
                    _userList.value = response.body()?.data
                    Log.e("User fragment 에러확인", _userList.value.toString())
                } else {
                    _userList.value = null
                    Log.e("User fragment 에러", response.toString())
                }
            }

            override fun onFailure(call: Call<ResponseUserDto>, t: Throwable) {
                _userList.value = null
                Log.e("User fragment 에러", "서버 통신 에러")
            }
        })
    }
}