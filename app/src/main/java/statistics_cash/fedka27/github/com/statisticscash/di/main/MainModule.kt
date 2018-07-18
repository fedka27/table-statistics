package statistics_cash.fedka27.github.com.statisticscash.di.main

import dagger.Module
import dagger.Provides
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractor
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractorImpl
import statistics_cash.fedka27.github.com.statisticscash.business.providers.AppProvider
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes.NotesRepository
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.user.UserRepository
import statistics_cash.fedka27.github.com.statisticscash.ui.main.MainContract
import statistics_cash.fedka27.github.com.statisticscash.ui.main.MainPresenter

@Module
class MainModule(private val view: MainContract.View) {

    @MainScope
    @Provides
    fun provideMainView(): MainContract.View {
        return view
    }

    @MainScope
    @Provides
    fun provideMainInteractor(notesRepository: NotesRepository,
                              userRepository: UserRepository): MainInteractor {
        return MainInteractorImpl(notesRepository, userRepository)
    }

    @MainScope
    @Provides
    fun provideMainPresenter(view: MainContract.View,
                             appProvider: AppProvider,
                             mainInteractor: MainInteractor): MainContract.Presenter {
        return MainPresenter(view, appProvider, mainInteractor)
    }

}