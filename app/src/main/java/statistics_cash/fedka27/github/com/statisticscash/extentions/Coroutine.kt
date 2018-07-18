package statistics_cash.fedka27.github.com.statisticscash.extentions

import statistics_cash.fedka27.github.com.statisticscash.R
import statistics_cash.fedka27.github.com.statisticscash.business.providers.AppProvider
import statistics_cash.fedka27.github.com.statisticscash.data.exceptions.NetworkException
import java.net.UnknownHostException

fun Throwable.toHumanThrowable(appProvider: AppProvider): Throwable {
    printStackTrace()
    return when (this) {
        is UnknownHostException -> NetworkException(appProvider.getString(R.string.exception_network_offline))
        else -> this
    }
}
