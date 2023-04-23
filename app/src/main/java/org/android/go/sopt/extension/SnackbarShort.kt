package org.android.go.sopt.extension
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.snackbarShort(message:String){
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}