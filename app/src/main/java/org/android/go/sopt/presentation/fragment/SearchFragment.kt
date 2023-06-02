package org.android.go.sopt.presentation.fragment

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.api.load
import org.android.go.sopt.databinding.FragmentSearchBinding
import org.android.go.sopt.extension.makeToastMessage
import org.android.go.sopt.model.SearchViewModel
import org.android.go.sopt.util.ContentUriRequestBody

class SearchFragment : Fragment() {
    private val viewModel by viewModels<SearchViewModel>()
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = requireNotNull(_binding) { Log.d("SearchFragment", "_binding이 null입니다") }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(maxItems = 3)) { imageUriList: List<Uri> ->
            with(binding) {
                when (imageUriList.size) {
                    0 -> {
                        requireContext().makeToastMessage("이미지를 선택하지 않았습니다.")
                    }

                    1 -> {
                        viewModel.setRequestBody(ContentUriRequestBody(requireContext(),imageUriList[0]))
                        ivGalleryFirst.load(imageUriList[0])
                        viewModel.uploadImage()
                    }

                    2 -> {
                        viewModel.setRequestBody(ContentUriRequestBody(requireContext(),imageUriList[0]))
                        ivGalleryFirst.load(imageUriList[0])
                        viewModel.setRequestBody(ContentUriRequestBody(requireContext(),imageUriList[1]))
                        ivGallerySecond.load(imageUriList[1])
                        viewModel.uploadImage()
                    }

                    3 -> {
                        viewModel.setRequestBody(ContentUriRequestBody(requireContext(),imageUriList[0]))
                        ivGalleryFirst.load(imageUriList[0])
                        viewModel.setRequestBody(ContentUriRequestBody(requireContext(),imageUriList[1]))
                        ivGallerySecond.load(imageUriList[1])
                        viewModel.setRequestBody(ContentUriRequestBody(requireContext(),imageUriList[2]))
                        ivGalleryThird.load(imageUriList[2])
                        viewModel.uploadImage()
                    }

                    else -> {
                        requireContext().makeToastMessage("3개의 이미지만 선택할 수 있습니다.")
                    }
                }
            }
        }

    private val locatePermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
        isGranted->
        if(isGranted){
            requireContext().makeToastMessage("정확한 위치 권한을 허가합니다.")
        }
        else{
            requireContext().makeToastMessage("위치 권한을 허가하지 않습니다.")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // 이제 반환하는 View가 Null일 수 없기 때문에, ?를 지워주셔도 됩니다.
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        locatePermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")

        binding.btnSearch.setOnClickListener {
            launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}