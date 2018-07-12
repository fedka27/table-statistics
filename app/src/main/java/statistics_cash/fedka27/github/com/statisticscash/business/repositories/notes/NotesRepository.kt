package statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes

import kotlinx.coroutines.experimental.Deferred
import statistics_cash.fedka27.github.com.statisticscash.data.dto.note.NoteDto

interface NotesRepository {

    fun getNotes(): Deferred<List<NoteDto>>

}