package com.snowyfox.littlelemonexpress.utility

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast

typealias Fun<A, B> = (A) -> B

fun <A, B> A.pipe(f: Fun<A, B>): B = f(this)
fun String.isValidEmail(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.message(context: Context) =
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()