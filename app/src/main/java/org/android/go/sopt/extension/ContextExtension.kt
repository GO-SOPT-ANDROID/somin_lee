package org.android.go.sopt.extension
import android.content.Context
import android.widget.Toast

fun Context.makeToastMessage(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}