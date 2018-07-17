package statistics_cash.fedka27.github.com.statisticscash.di

import dagger.Component
import statistics_cash.fedka27.github.com.statisticscash.di.api.ApiModule
import statistics_cash.fedka27.github.com.statisticscash.di.main.MainModule
import statistics_cash.fedka27.github.com.statisticscash.di.main.MainSubcomponent

@AppScope
@Component(modules = [
    AppModule::class,
    RepositoryModule::class,
    ApiModule::class
])
interface AppComponent {

    fun plusMainSubcomponent(mainModule: MainModule): MainSubcomponent

}