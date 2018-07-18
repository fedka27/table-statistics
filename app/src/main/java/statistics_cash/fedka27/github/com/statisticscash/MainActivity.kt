package statistics_cash.fedka27.github.com.statisticscash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.*
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractor
import statistics_cash.fedka27.github.com.statisticscash.business.providers.AppProvider
import statistics_cash.fedka27.github.com.statisticscash.data.api.Api
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.data.dto.sign_in.SignIn
import statistics_cash.fedka27.github.com.statisticscash.di.ComponentProvider
import statistics_cash.fedka27.github.com.statisticscash.extentions.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainInteractor: MainInteractor

    @Inject
    lateinit var api: Api

    @Inject
    lateinit var appProvider: AppProvider

    private val parentJob = Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ComponentProvider.Main.getMainSubcomponent().inject(this)

        setContentView(R.layout.activity_main)

        initListeners()

        test()
    }

    private fun test() = runBlocking(CoroutineName("main")) {


    }

    private fun initListeners() {
        loadButton.setOnClickListener {
            loadNotes()
            testSignIn()
        }
        insertRandom.setOnClickListener {
            insertToDbRandom()
        }
    }

    @Throws
    private fun testSignIn() {
        launch(uiContext + parentJob + CoroutineExceptionHandler { _, throwable ->
            throwable.toHumanThrowable(appProvider).apply { helloTextView.text = message }
        }) {

            val user = withContext(netContext) { mainInteractor.signIn(SignIn("Dmitriy.Kirsh@russianpost.ru", "123")) }

            helloTextView.text = "Hello, ${user.fullName}!"

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
            log_i(localClassName, message)
            helloTextView.text = message
        }
    }

    private fun insertToDbRandom() {
        launch(context = uiContext + parentJob) {
            val noteResult = withContext(ioContext) { mainInteractor.insert(Note.createRandom()) }

            val note = noteResult.note

            val size = noteResult.sizeOfNotes

            val message = "Created: ${note.title}\n" +
                    "Size of notes: $size"

            log_i(localClassName, message)
            helloTextView.text = message

        }
    }


    override fun onStop() {
        parentJob.cancel()
        super.onStop()
    }
}
