package statistics_cash.fedka27.github.com.statisticscash.di.main

import dagger.Module
import dagger.Provides
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractor
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractorImpl
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes.NotesRepository
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.user.UserRepository

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideMainInteractor(notesRepository: NotesRepository,
                              userRepository: UserRepository): MainInteractor {
        return MainInteractorImpl(notesRepository, userRepository)
    }

}