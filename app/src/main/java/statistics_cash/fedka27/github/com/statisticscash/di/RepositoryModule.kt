package statistics_cash.fedka27.github.com.statisticscash.di

import dagger.Module
import dagger.Provides
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes.NoteRepositoryImpl
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes.NotesRepository
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.user.UserRepository
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.user.UserRepositoryImpl
import statistics_cash.fedka27.github.com.statisticscash.data.api.Api
import statistics_cash.fedka27.github.com.statisticscash.data.database.AppDatabase
import statistics_cash.fedka27.github.com.statisticscash.data.database.notes.NotesDao
import statistics_cash.fedka27.github.com.statisticscash.data.mapper.api.ApiMapper

@Module
class RepositoryModule {

    @AppScope
    @Provides
    fun provideNotesDao(appDatabase: AppDatabase): NotesDao {
        return appDatabase.getNotesDao()
    }

    @AppScope
    @Provides
    fun provideNotesRepository(notesDao: NotesDao): NotesRepository {
        return NoteRepositoryImpl(notesDao)
    }

    @AppScope
    @Provides
    fun provideUserRepository(api: Api,
                              apiMapper: ApiMapper): UserRepository {
        return UserRepositoryImpl(api, apiMapper)
    }
}