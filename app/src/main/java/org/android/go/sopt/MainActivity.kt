package org.android.go.sopt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ActivityMainBinding
import org.android.go.sopt.home.GalleryFragment
import org.android.go.sopt.home.HomeFragment
import org.android.go.sopt.home.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val currentFragment = supportFragmentManager.findFragmentById(R.id.fcvMain)

    private val hf = HomeFragment()
    private val sf = SearchFragment()
    private val gf = GalleryFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 액티비티에서 사용할 바인딩 클래스의 객체화
        setContentView(binding.root) // getRoot 메서드로 레이아웃 최상단 뷰를 액티비티에 표시 합니다
        initView()
    }

    private fun initView() {
        if (currentFragment == null) { // 스택이 비어있으면
            supportFragmentManager.beginTransaction()
                .add(binding.fcvMain.id, hf) // fragmentContainerView add
                .commit()
        }

        // 네비게이션 바 클릭시 fragment 이동
        binding.homeCustomBottom.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.menuHome -> {
                    hf
                }
                R.id.menuSearch -> {
                    sf
                }
                R.id.menuGallery -> {
                    gf
                }
                else -> { // 이렇게 하면 좋지 않음..
                    null
                }
            }
            if (fragment != null) {
                changeFragment(fragment)
                true
            } else {
                false
            } // 람다는 맨 마지막 구문을 return으로 본다!
        }

        // home '재'클릭시 스크롤 맨 위로 이동
        binding.homeCustomBottom.setOnItemReselectedListener { item ->
            if (item.itemId == R.id.menuHome) {
                scrollToTop(hf.binding.rvHome)
            }
        }
    }

    private fun scrollToTop(recyclerView: RecyclerView) {
        recyclerView.smoothScrollToPosition(0)
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fcvMain.id, fragment)
            .commit()
    }
}