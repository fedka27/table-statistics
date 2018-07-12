package statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes

import kotlinx.coroutines.experimental.Deferred
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note

interface NotesRepository {

    @Throws
    fun getNotes(): Deferred<List<Note>>

    @Throws
    fun insert(note: Note): Deferred<Int>

    @Throws
    fun update(note: Note): Deferred<Note>

}