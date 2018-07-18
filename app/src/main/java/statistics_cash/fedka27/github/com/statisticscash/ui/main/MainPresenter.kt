package statistics_cash.fedka27.github.com.statisticscash.ui.main

import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractor
import statistics_cash.fedka27.github.com.statisticscash.business.providers.AppProvider
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.data.dto.sign_in.SignIn
import statistics_cash.fedka27.github.com.statisticscash.extentions.*

class MainPresenter(override val view: MainContract.View,
                    private val appProvider: AppProvider,
                    private val mainInteractor: MainInteractor) : MainContract.Presenter {
    private val parentJob = Job()

    override fun onLoadPressed() {
        loadNotes()
        testSignIn()
    }


    @Throws
    private fun testSignIn() {
        launch(uiContext + parentJob + CoroutineExceptionHandler { _, throwable ->
            throwable.toHumanThrowable(appProvider).apply { view.onError(message) }
        }) {

            val user = withContext(netContext) { mainInteractor.signIn(SignIn("Dmitriy.Kirsh@russianpost.ru", "123")) }

            view.setText("Hello, ${user.fullName}!")

        }
    }


    private fun loadNotes() {
        launch(uiContext + parentJob) {

            val list: List<Note> = withContext(ioContext) { mainInteractor.getNotes() }

            val lastNote = if (list.isEmpty()) null else list.last()

            val lastNoteMessage = if (lastNote != null) "Last note: ${lastNote.title}\n" +
                    "Created at: ${lastNote.getCreatedDateTime()}"
            else "Empty notes"

            val message = "Size of note: ${list.size}\n" +
                    lastNoteMessage

            log_i(message)

            view.setText(message)
        }
    }


    override fun insertNote(note: Note) {
        launch(context = uiContext + parentJob) {
            val noteResult = withContext(ioContext) { mainInteractor.insert(note) }

            val note = noteResult.note

            val size = noteResult.sizeOfNotes

            val message = "Created: ${note.title}\n" +
                    "Size of notes: $size"

            log_i(message)
            view.setText(message)

        }
    }

    override fun onStop() {
        parentJob.cancel()
    }
}