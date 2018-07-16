package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import kotlinx.coroutines.experimental.Job
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes.NotesRepository
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.data.dto.NoteInsertResult

class MainInteractorImpl(
        private val notesRepository: NotesRepository
) : MainInteractor {

    val job = Job()

    override suspend fun getNotes(): List<Note> {
        return notesRepository.getNotes()
    }

    override suspend fun insert(note: Note): NoteInsertResult {
        val size = notesRepository.insert(note)

        return NoteInsertResult(note, size)
    }

    override fun cancel() {
        job.cancel()
    }
}