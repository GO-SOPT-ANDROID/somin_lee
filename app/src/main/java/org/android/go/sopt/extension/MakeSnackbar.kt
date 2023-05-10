package org.android.go.sopt.extension
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.makeSnackbar(message:String, duration: Int = Snackbar.LENGTH_SHORT){
    Snackbar.make(this, message, duration).show()
}