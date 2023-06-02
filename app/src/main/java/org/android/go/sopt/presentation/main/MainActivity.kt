package org.android.go.sopt.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityMainBinding
import org.android.go.sopt.presentation.fragment.*
import org.android.go.sopt.presentation.login.LoginActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val currentFragment = supportFragmentManager.findFragmentById(R.id.fcvMain)

    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val userFragment = UserFragment()
    private val galleryFragment = GalleryFragment()
    private val myPageFragment = MyPageFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 액티비티에서 사용할 바인딩 클래스의 객체화
        setContentView(binding.root)

        // 자동 로그인
        val autoLogin = getSharedPreferences("AutoLogin", Context.MODE_PRIVATE) //해당 데이터는 해당 앱에서만 사용할 수 있다
        val userId = autoLogin.getString("KEY_ID", null)

        // 로그인 정보를 가져옴
        getUserData()

        if (!userId.isNullOrBlank()) {
            // 로그인 로직을 실행하거나 홈 화면으로 이동하는 등의 동작을 수행합니다.
        initView()
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            finish()
            startActivity(intent)
            if (userId != null) {
                Log.d("자동 로그인 결과", userId)
            }
        }
    }

    private fun initView() {

        if (currentFragment == null) { // 스택이 비어있으면
            supportFragmentManager.beginTransaction()
                .add(binding.fcvMain.id, homeFragment) // fragmentContainerView add
                .commit()
        }

        // 네비게이션 바 클릭시 fragment 이동
        binding.homeCustomBottom.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.menuHome -> {
                    homeFragment
                }
                R.id.menuSearch -> {
                    searchFragment
                }
                R.id.menuUser -> {
                    userFragment
                }
                R.id.menuGallery -> {
                    galleryFragment
                }
                R.id.menuMyPage -> {
                    myPageFragment
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
                scrollToTop(homeFragment.binding.rvHome)
            }
        }
    }

    /**로그인 한 유저의 정보를 받아 마이페이지 fragment로 전달*/
    private fun getUserData() = with(binding) {
        myPageFragment.arguments = intent.extras
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