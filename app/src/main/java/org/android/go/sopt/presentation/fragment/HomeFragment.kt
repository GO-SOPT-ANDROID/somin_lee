package org.android.go.sopt.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.android.go.sopt.databinding.FragmentHomeBinding
import org.android.go.sopt.model.HomeViewModel
import org.android.go.sopt.presentation.recycler.MultiViewAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    val binding get() = requireNotNull(_binding) { "앗 ! _binding이 null이다 !" } //에러 메시지
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView( // 제일 처음 뷰가 생성될 때 실행
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // 이제 반환하는 View가 Null일 수 없기 때문에, ?를 지워주셔도 됩니다.
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // 뷰가 생성된 후에 실행
        super.onViewCreated(view, savedInstanceState)

        val adapter = MultiViewAdapter(viewModel.mockAnimationList)
        binding.rvHome.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // View와 객체의 생명주기 차이로 인한 메모리 누수를 방지하기 위해 직접 binding을 해제해준다
    }
}