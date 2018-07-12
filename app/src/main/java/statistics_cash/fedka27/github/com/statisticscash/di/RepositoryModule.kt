package statistics_cash.fedka27.github.com.statisticscash.di

import dagger.Module
import dagger.Provides
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes.NoteRepositoryImpl
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes.NotesRepository
import statistics_cash.fedka27.github.com.statisticscash.data.database.AppDatabase
import statistics_cash.fedka27.github.com.statisticscash.data.database.notes.NotesDao

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
}