package statistics_cash.fedka27.github.com.statisticscash.extentions

import android.util.Log


fun Any.threadName() = Thread.currentThread().name

fun Any.tag(): String = javaClass.simpleName

fun Any.joinTag(tag: String): String = "$tag [${threadName()}]"

fun Any.log_i(message: String) {
    log_i(tag(), message)
}

fun Any.log_d(message: String) {
    log_d(tag(), message)
}

fun Any.log_e(message: String) {
    log_e(tag(), message)
}

fun Any.log_i(tag: String, message: String) {
    Log.i(joinTag(tag), message)
}

fun Any.log_d(tag: String, message: String) {
    Log.d(joinTag(tag), message)
}

fun Any.log_e(tag: String, message: String) {
    Log.e(joinTag(tag), message)
}
