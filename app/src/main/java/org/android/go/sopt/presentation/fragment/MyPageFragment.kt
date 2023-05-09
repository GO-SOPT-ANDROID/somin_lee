package org.android.go.sopt.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.android.go.sopt.databinding.FragmentMyPageBinding
import org.android.go.sopt.model.UserData


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
        val loginData = arguments?.getParcelable<UserData>("user_data")
        if (loginData != null){
            val userIntro = "${loginData.nickname}의 한 마디"
            val introMessage = "${loginData.tmi}"
            binding.resultNickname.text = userIntro
            binding.resultTmi.text = introMessage
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}