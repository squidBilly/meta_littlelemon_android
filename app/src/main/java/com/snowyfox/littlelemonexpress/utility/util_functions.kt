package com.snowyfox.littlelemonexpress.utility

import android.text.TextUtils
import android.util.Patterns

typealias Fun<A, B> = (A) -> B
fun <A, B> A.pipe(f: Fun<A, B>):B = f(this)
fun String.isValidEmail(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}