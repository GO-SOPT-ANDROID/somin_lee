package org.android.go.sopt.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.android.go.sopt.databinding.FragmentUserBinding
import org.android.go.sopt.extension.makeSnackbar
import org.android.go.sopt.model.ReadUserServicePool.readUserService
import org.android.go.sopt.model.ResponseListUserDto
import org.android.go.sopt.model.UserData
import org.android.go.sopt.presentation.UserAdapter
import retrofit2.Call
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
        // 대부분의 로직은 여기에 구현합니다.
        val adapter = UserAdapter()
        binding.rvUser.adapter = adapter
        Log.d("어느 fragment?", "여긴 들어왔어")
        readUserService.roadUsers(1).enqueue(object : retrofit2.Callback<ResponseListUserDto> {
            override fun onResponse(
                call: Call<ResponseListUserDto>, response: Response<ResponseListUserDto>
            ) {
                if (response.isSuccessful) {
                    Log.d("어느 fragment?", " 성공")
                    adapter.setUserList(response.body()?.data?.map {
                        return@map UserData(
                            it.avatar, "${it.first_name} ${it.last_name}", it.email
                        )
                    } ?: emptyList())
                } else {
                    binding.root.makeSnackbar("1.유저를 불러올 수 없습니다.")
                    Log.d("어느 error fragment?", "1번")
                }
            }
            override fun onFailure(call: Call<ResponseListUserDto>, t: Throwable) {
                Log.d("어느 error fragment?", "2번")
                binding.root.makeSnackbar("2.유저를 불러올 수 없습니다.")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

//    private fun roadUserData() {
//        val adapter = UserAdapter(requireContext())
//        binding.rvUser.adapter = adapter
//        readUserService.roadUsers(1).enqueue(object : retrofit2.Callback<ResponseListUserDto> {
//                override fun onResponse(
//                    call: Call<ResponseListUserDto>, response: Response<ResponseListUserDto>
//                ) {
//                    if (response.isSuccessful) {
//                        adapter.setUserList(response.body()?.data?.map {
//                            return@map UserData(
//                                it.avatar, "${it.first_name} ${it.last_name}", it.email
//                            )
//                        } ?: emptyList())
//                    } else {
//                        context?.makeToastMessage("유저를 불러올 수 없습니다.")
//                    }
//                }
//                override fun onFailure(call: Call<ResponseListUserDto>, t: Throwable) {
//                    context?.makeToastMessage("유저를 불러올 수 없습니다.")
//                }
//            })
//    }
//}