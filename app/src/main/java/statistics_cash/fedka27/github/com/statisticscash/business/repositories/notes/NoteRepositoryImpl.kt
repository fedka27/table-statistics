package statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import statistics_cash.fedka27.github.com.statisticscash.data.database.dto.note.NoteDto
import statistics_cash.fedka27.github.com.statisticscash.data.database.notes.NotesDao

class NoteRepositoryImpl(
        private val notesDao: NotesDao
) : NotesRepository {

    override fun getNotes(): Deferred<List<NoteDto>> {
        return async { notesDao.getAllNotes() }
    }

    override fun insert(noteDto: NoteDto): Deferred<Int> {
        return async {
            notesDao.putNote(noteDto)
            return@async notesDao.getAllNotes().size
        }
    }
}