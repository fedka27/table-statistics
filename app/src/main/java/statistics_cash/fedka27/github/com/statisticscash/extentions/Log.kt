package statistics_cash.fedka27.github.com.statisticscash.extentions

import android.util.Log


fun Any.tag(): String = javaClass.simpleName

fun Any.log_d(message: String) {
    log_d(tag(), message)
}

fun Any.log_d(tag: String, message: String) {
    Log.d(tag(), "$tag: $message")
}

fun Any.log_e(tag: String, message: String) {
    Log.e(tag(), "$tag: $message")
}

fun Any.log_e(message: String) {
    log_e(tag(), message)
}
