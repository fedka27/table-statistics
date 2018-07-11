package statistics_cash.fedka27.github.com.statisticscash.di

import android.app.Application
import statistics_cash.fedka27.github.com.statisticscash.di.main.MainModule
import statistics_cash.fedka27.github.com.statisticscash.di.main.MainSubcomponent

object ComponentProvider {
    private var appComponent: AppComponent? = null

    fun init(application: Application) {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(application))
                .build();
    }

    fun getAppComponent() = appComponent!!

    object Main{
        private var mainComponent: MainSubcomponent? = null

        fun getMainSubcomponent() : MainSubcomponent {
            return getAppComponent().plusMainSubcomponent(MainModule())
        }
    }


}