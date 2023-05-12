package org.android.go.sopt.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.android.go.sopt.databinding.FragmentUserBinding
import org.android.go.sopt.model.UserViewModel
import org.android.go.sopt.presentation.UserAdapter

class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding
        get() = requireNotNull(_binding) { "앗 ! _binding이 null이다 !" }
    private val viewModel by viewModels<UserViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View { // 이제 반환하는 View가 Null일 수 없기 때문에, ?를 지워주셔도 됩니다.
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 대부분의 로직은 여기에 구현합니다.

        roadUserData()
        val adapter = UserAdapter(requireContext())
        binding.rvUser.adapter = adapter
        adapter.setUserList(viewModel.mockUserList)
        Log.d("어느 fragment?","User입니당")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun roadUserData(){

    }
}