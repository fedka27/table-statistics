package statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import statistics_cash.fedka27.github.com.statisticscash.data.database.notes.NotesDao
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.data.mapper.NoteMapper
import statistics_cash.fedka27.github.com.statisticscash.extentions.toDateTimeFormat
import java.util.*

class NoteRepositoryImpl(
        private val notesDao: NotesDao
) : NotesRepository {
    private val noteMapper = NoteMapper()

    override fun getNotes(): Deferred<List<Note>> {
        return async {
            notesDao.getAllNotes()
                    .map { noteMapper.map(it) }
        }
    }

    override fun insert(note: Note): Deferred<Int> {
        return async {

            val noteDbo = noteMapper.mapRevert(note)

            notesDao.putNote(noteDbo)

            return@async notesDao.getNotesSize()
        }
    }

    override fun update(note: Note): Deferred<Note> {
        return async {

            note.updatedAt = Date().toDateTimeFormat()

            val noteDbo = noteMapper.mapRevert(note)

            notesDao.update(noteDbo)

            return@async note
        }
    }
}