package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes.NotesRepository
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.extentions.uiContext

class MainInteractorImpl(
        private val notesRepository: NotesRepository
) : MainInteractor {

    val job = Job()

    override fun getNotes(success: (List<Note>) -> Unit,
                          error: (Throwable) -> Unit) {
        launch(context = uiContext,
                parent = job) {
            val notes = notesRepository.getNotes().await()

            success.invoke(notes)
        }
    }

    override fun insert(note: Note, success: (Note, Int) -> Unit, error: (Throwable) -> Unit) {
        launch(context = uiContext,
                parent = job) {
            val size = notesRepository.insert(note).await()

            success.invoke(note, size)
        }
    }

    override fun cancel() {
        job.cancel()
    }
}