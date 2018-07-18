package statistics_cash.fedka27.github.com.statisticscash.business.providers

import android.content.Context
import statistics_cash.fedka27.github.com.statisticscash.extentions.isOnline

class AppProviderImpl(private val context: Context) : AppProvider {

    override fun getString(stringRes: Int): String {
        return context.getString(stringRes)
    }

    override fun isConnectionInternet(): Boolean {
        return context.isOnline()
    }

}