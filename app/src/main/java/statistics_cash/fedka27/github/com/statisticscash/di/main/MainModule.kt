package statistics_cash.fedka27.github.com.statisticscash.di.main

import dagger.Module
import dagger.Provides
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractor
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractorImpl

@Module
class MainModule{

    @MainScope
    @Provides
    fun provideMainInteractor(): MainInteractor {
        return MainInteractorImpl()
    }

}