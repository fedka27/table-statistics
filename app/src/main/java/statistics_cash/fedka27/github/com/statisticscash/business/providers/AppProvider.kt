package statistics_cash.fedka27.github.com.statisticscash.business.providers

import android.support.annotation.StringRes

interface AppProvider {

    fun getString(@StringRes stringRes: Int): String

    fun isConnectionInternet(): Boolean

}