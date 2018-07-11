package statistics_cash.fedka27.github.com.statisticscash

import android.app.Application
import statistics_cash.fedka27.github.com.statisticscash.di.ComponentProvider

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        ComponentProvider.init(this)

    }
}