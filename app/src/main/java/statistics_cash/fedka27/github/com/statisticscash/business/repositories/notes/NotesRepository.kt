package statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes

import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note

interface NotesRepository {

    @Throws
    suspend fun getNotes(): List<Note>

    @Throws
    suspend fun insert(note: Note): Int

    @Throws
    suspend fun update(note: Note): Note

}