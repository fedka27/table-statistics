package statistics_cash.fedka27.github.com.statisticscash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.*
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractor
import statistics_cash.fedka27.github.com.statisticscash.data.api.Api
import statistics_cash.fedka27.github.com.statisticscash.data.api.requests.SignInRequest
import statistics_cash.fedka27.github.com.statisticscash.data.api.responses.SignInResponse
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.di.ComponentProvider
import statistics_cash.fedka27.github.com.statisticscash.extentions.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainInteractor: MainInteractor

    @Inject
    lateinit var api: Api

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

    @Throws(RuntimeException::class)
    private fun testSignIn() {
        launch(uiContext + parentJob) {
            try {
                val signInRequest = SignInRequest("Dmitriy.Kirsh@russianpost.ru", "1234")

                val result = withContext(netContext) { api.signIn(signInRequest) }.await()

                //todo move to valid mapper
                val json = result.errorBody()!!.string()
                log("json: $json")
                val resultResponse = Gson().fromJson(json, SignInResponse::class.java)!!
                log("signInResponse: $resultResponse")

                resultResponse.apply {
                    if (!success) {
                        val exception = exception

                        throw RuntimeException(exception?.message)
                    } else {
                        helloTextView.text = "Hello, ${user.fullName}!"
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                helloTextView.text = e.message
            }
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
