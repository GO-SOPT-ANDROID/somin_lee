package org.android.go.sopt.extension
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.makeSnackbar(message:String, duration: Int = Snackbar.LENGTH_SHORT){
    Snackbar.make(this, message, duration).show()
}

//fun View.hideKeyboard() {
//    val imm: InputMethodManager? = getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as? InputMethodManager
//    imm?.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
//    return super.dispatchTouchEvent(ev)
//}