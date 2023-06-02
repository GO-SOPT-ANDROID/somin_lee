package org.android.go.sopt.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import org.android.go.sopt.databinding.FragmentUserBinding
import org.android.go.sopt.model.user.UserViewModel
import org.android.go.sopt.presentation.recycler.UserAdapter

class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding
        get() = requireNotNull(_binding)

    private val viewModel by viewModels<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() {
        val adapter = UserAdapter()
        binding.rvUser.layoutManager = GridLayoutManager(context, 2)
        binding.rvUser.adapter = adapter
        viewModel.initView()

        viewModel.userList.observe(viewLifecycleOwner) {
            adapter.setUserList(viewModel.userList.value)
        }
    }
}