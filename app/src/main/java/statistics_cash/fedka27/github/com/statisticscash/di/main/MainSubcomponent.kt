package statistics_cash.fedka27.github.com.statisticscash.di.main

import dagger.Subcomponent
import statistics_cash.fedka27.github.com.statisticscash.ui.MainActivity

@MainScope
@Subcomponent(modules = [
    (MainModule::class)
])
interface MainSubcomponent {

    fun inject(mainActivity: MainActivity)

}