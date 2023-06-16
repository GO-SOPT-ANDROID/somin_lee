package org.android.go.sopt.presentation.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.android.go.sopt.databinding.FragmentMyPageBinding
import org.android.go.sopt.extension.makeToastMessage
import org.android.go.sopt.presentation.login.LoginActivity


class MyPageFragment : Fragment() {


    private var _binding: FragmentMyPageBinding? = null
    private val binding: FragmentMyPageBinding
        get() = requireNotNull(_binding) { "앗 ! _binding이 null이다 !" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // 이제 반환하는 View가 Null일 수 없기 때문에, ?를 지워주셔도 됩니다.
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 대부분의 로직은 여기에 구현합니다.
        initFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initFragment() {
        // 자동 로그인
        val autoLogin = requireContext().getSharedPreferences("AutoLogin", Context.MODE_PRIVATE) //해당 데이터는 해당 앱에서만 사용할 수 있다
        val userNickname = "${autoLogin.getString("KEY_NICKNAME", null)}의 한 마디"
        val introMessage = autoLogin.getString("KEY_INTRO", null)
            binding.resultNickname.text = userNickname
            binding.resultTmi.text = introMessage

        binding.btLogout.setOnClickListener {
            logout(autoLogin)
        }
    }

    //    로그아웃 시 호출할 메소드
    private fun logout(autoLogin : SharedPreferences) {
        val autoLoginEdit = autoLogin.edit()
        autoLoginEdit.clear()
        autoLoginEdit.apply()
        requireContext().makeToastMessage("로그아웃 합니다.")
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}