package statistics_cash.fedka27.github.com.statisticscash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractor
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.di.ComponentProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainInteractor: MainInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ComponentProvider.Main.getMainSubcomponent().inject(this)

        setContentView(R.layout.activity_main)

        initListeners()

    }

    private fun initListeners() {
        loadButton.setOnClickListener {
            mainInteractor.getNotes(
                    success = {
                        val lastNote = if (it.isEmpty()) null else it.last()

                        val lastNoteMessage = if (lastNote != null) "Last note: ${lastNote.title}\n" +
                                "created at: ${lastNote.getCreatedDateTime()}"
                        else "Empty notes"

                        val message = "size of note: ${it.size}\n" +
                                lastNoteMessage
                        Log.i(localClassName, message)
                        helloTextView.text = message
                    })
        }
        insertRandom.setOnClickListener {
            mainInteractor.insert(Note.createRandom(),
                    success = { note, size ->
                        val message = "Created: ${note.title}\nsize of notes: $size"

                        Log.i(localClassName, message)
                        helloTextView.text = message
                    })
        }
    }
}
