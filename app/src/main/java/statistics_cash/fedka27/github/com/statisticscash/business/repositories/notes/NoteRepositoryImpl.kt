package statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes

import statistics_cash.fedka27.github.com.statisticscash.data.database.notes.NotesDao
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.data.mapper.NoteMapper
import statistics_cash.fedka27.github.com.statisticscash.extentions.toDateTimeFormat
import java.util.*

class NoteRepositoryImpl(
        private val notesDao: NotesDao
) : NotesRepository {
    private val noteMapper = NoteMapper()

    override suspend fun getNotes(): List<Note> {
        return notesDao.getAllNotes()
                .map { noteMapper.map(it) }
    }

    override suspend fun insert(note: Note): Int {

        val noteDbo = noteMapper.mapRevert(note)

        notesDao.putNote(noteDbo)

        return notesDao.getNotesSize()

    }

    override suspend fun update(note: Note): Note {

        note.updatedAt = Date().toDateTimeFormat()

        val noteDbo = noteMapper.mapRevert(note)

        notesDao.update(noteDbo)

        return note
    }
}