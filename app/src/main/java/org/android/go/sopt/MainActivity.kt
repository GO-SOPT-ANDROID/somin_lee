package org.android.go.sopt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.android.go.sopt.databinding.ActivityMainBinding
import org.android.go.sopt.home.GalleryFragment
import org.android.go.sopt.home.HomeFragment
import org.android.go.sopt.home.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val currentFragment = supportFragmentManager.findFragmentById(R.id.fcvMain)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 액티비티에서 사용할 바인딩 클래스의 객체화
        setContentView(binding.root) // getRoot 메서드로 레이아웃 최상단 뷰를 액티비티에 표시 합니다
        val hf = HomeFragment()
        val sf = SearchFragment()
        val gf = GalleryFragment()

        if (currentFragment == null) { // 비어있으면
            supportFragmentManager.beginTransaction()
                .add(binding.fcvMain.id, hf)
                .commit()
        }

        binding.homeCustomBottom.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.menu_home -> {
                    hf
                }
                R.id.menu_search -> {
                    sf
                }
                R.id.menu_gallery -> {
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
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fcvMain.id, fragment)
            .commit()
    }
}