package statistics_cash.fedka27.github.com.statisticscash.extentions

import android.util.Log


fun Any.threadName() = Thread.currentThread().name

fun Any.tag(): String = javaClass.simpleName

fun Any.joinTag(tag: String): String = "$tag [${threadName()}]"


fun Any.log_i(tag: String = tag(), message: String) {
    Log.i(joinTag(tag), message)
}

fun Any.log_d(tag: String = tag(), message: String) {
    Log.d(joinTag(tag), message)
}

fun Any.log_e(tag: String = tag(), message: String) {
    Log.e(joinTag(tag), message)
}
