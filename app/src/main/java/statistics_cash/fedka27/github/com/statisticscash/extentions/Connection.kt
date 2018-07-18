package statistics_cash.fedka27.github.com.statisticscash.extentions

import android.content.Context
import android.net.ConnectivityManager

fun Context.isOnline(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = connectivityManager.activeNetworkInfo
    return info != null && info.isConnectedOrConnecting
}