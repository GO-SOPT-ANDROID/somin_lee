package org.android.go.sopt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.android.go.sopt.databinding.ActivityMainBinding
import org.android.go.sopt.home.GalleryFragment
import org.android.go.sopt.home.HomeFragment
import org.android.go.sopt.home.SearchFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 액티비티에서 사용할 바인딩 클래스의 객체화
        setContentView(binding.root) // getRoot 메서드로 레이아웃 최상단 뷰를 액티비티에 표시 합니다
        val hf = HomeFragment()
        val sf = SearchFragment()
        val gf = GalleryFragment()

        if (currentFragment == null) { // 비어있으면
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_main, hf)
                .remove(hf)
                .add(R.id.fcv_main, sf)
                .replace(R.id.fcv_main, gf)
                .commit()
        }

//        binding.bnvMain.setOnItemSelectedListener { item ->
//            changeFragment(
//                when (item.itemId) {
//                    R.id.menu_home -> {
//                        HomeFragment()
//                        return@setOnItemSelectedListener true
//                    }
//                    R.id.menu_search -> {
//                        SearchFragment()
//                        return@setOnItemSelectedListener true
//                    }
//                    R.id.menu_gallery -> {
//                        GalleryFragment()
//                        return@setOnItemSelectedListener true
//                    }
//                    false
//                }
//            )
//        }
    }
    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_home, fragment)
            .commit()
    }
}