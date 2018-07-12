package statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import statistics_cash.fedka27.github.com.statisticscash.data.database.notes.NotesDao
import statistics_cash.fedka27.github.com.statisticscash.data.dto.note.NoteDto

class NoteRepositoryImpl(
        private val notesDao: NotesDao
) : NotesRepository {

    override fun getNotes(): Deferred<List<NoteDto>> {
        return async { notesDao.getAllNotes() }
    }
}