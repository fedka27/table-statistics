package statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes

import kotlinx.coroutines.experimental.Deferred
import statistics_cash.fedka27.github.com.statisticscash.data.database.dto.note.NoteDto

interface NotesRepository {

    @Throws
    fun getNotes(): Deferred<List<NoteDto>>

    @Throws
    fun insert(noteDto: NoteDto): Deferred<Int>

}