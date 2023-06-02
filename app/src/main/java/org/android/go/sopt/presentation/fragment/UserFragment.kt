package org.android.go.sopt.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import org.android.go.sopt.databinding.FragmentUserBinding
import org.android.go.sopt.model.ApiFactory.readUserRetrofit
import org.android.go.sopt.model.user.ResponseUserDto
import org.android.go.sopt.presentation.recycler.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding
        get() = requireNotNull(_binding) { "앗 ! _binding이 null이다 !" }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UserAdapter()
        binding.rvUser.layoutManager = GridLayoutManager(context, 2)
        binding.rvUser.adapter = adapter

        readUserRetrofit.readUsers(1).enqueue(object : Callback<ResponseUserDto> {
            override fun onResponse(
                call: Call<ResponseUserDto>,
                response: Response<ResponseUserDto>
            ) {
                if (response.isSuccessful) {
                    val responseUserDataList = response.body()?.data
                    adapter.setUserList(responseUserDataList!!)
                } else {
                    Log.e("User fragment 에러", response.toString())
                }
            }
            override fun onFailure(call: Call<ResponseUserDto>, t: Throwable) {
                Log.e("User fragment 에러","서버 통신 에러")
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}