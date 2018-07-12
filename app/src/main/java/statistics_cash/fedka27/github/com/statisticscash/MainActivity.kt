package statistics_cash.fedka27.github.com.statisticscash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractor
import statistics_cash.fedka27.github.com.statisticscash.data.database.dto.note.NoteDto
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

        loadWithApi()
    }

    private fun initListeners() {
        loadButton.setOnClickListener {
            mainInteractor.getNotes(
                    success = {
                        Log.i(localClassName, "notes: ${it.map { it.title }}")
                    })
        }
        insertRandom.setOnClickListener {
            mainInteractor.insert(NoteDto.createRandom(),
                    success = {
                        Log.i(localClassName, "size of notes: $it")
                    })
        }
    }

    private fun loadWithApi() {
        mainInteractor.testAsync(
                onNext = {
                    Log.i(localClassName, "onNext: $it")
                    helloTextView.text = it
                },
                success = {
                    Log.i(localClassName, "success: $it")
                    helloTextView.text = it
                },
                error = {
                    Log.e(localClassName, "error: $it")
                    helloTextView.text = it.localizedMessage
                })
    }
}
