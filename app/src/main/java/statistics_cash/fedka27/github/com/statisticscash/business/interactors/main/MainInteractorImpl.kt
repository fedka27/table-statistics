package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.cancel
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import statistics_cash.fedka27.github.com.statisticscash.business.repositories.notes.NotesRepository
import statistics_cash.fedka27.github.com.statisticscash.data.database.dto.note.NoteDto
import statistics_cash.fedka27.github.com.statisticscash.extentions.uiContext

class MainInteractorImpl(
        private val notesRepository: NotesRepository
) : MainInteractor {

    val job = Job()

    override fun testAsync(onNext: (String) -> Unit,
                           success: (String) -> Unit,
                           error: (Throwable) -> Unit
    ): Job {
        return launch(
                context = uiContext,
                parent = job,
                block = {
                    var seconds = 0

                    while (seconds <= 60) {
                        delay(1000)

                        seconds++

                        try {
                            if (seconds == 5) {
                                throw IllegalStateException("Stopped timer")
                            }
                        } catch (e: IllegalStateException) {
                            coroutineContext.cancel()
                            error.invoke(e)
                            return@launch
                        }
                        onNext.invoke("$seconds")

                    }

                    success.invoke("$seconds")
                })
    }

    override fun getNotes(success: (List<NoteDto>) -> Unit,
                          error: (Throwable) -> Unit) {
        launch(context = uiContext) {
            val notes = notesRepository.getNotes().await()

            success.invoke(notes)
        }
    }

    override fun insert(noteDto: NoteDto, success: (Int) -> Unit, error: (Throwable) -> Unit) {
        launch(context = uiContext) {
            val size = notesRepository.insert(noteDto).await()

            success.invoke(size)
        }
    }

    override fun cancel() {
        job.cancel()
    }
}