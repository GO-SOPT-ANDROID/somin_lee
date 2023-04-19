//package org.android.go.sopt.extension
//
//import android.view.MotionEvent
//import android.view.View
//import android.view.inputmethod.InputMethodManager
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.ContextCompat.getSystemService
//
//fun View.hideKeyboard() { // 얘 따로 빼고 싶어
//    val imm: InputMethodManager? = getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as? InputMethodManager
//    imm?.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
//    return super.dispatchTouchEvent(ev)
//}