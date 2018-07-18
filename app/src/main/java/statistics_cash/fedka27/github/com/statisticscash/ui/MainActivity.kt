package statistics_cash.fedka27.github.com.statisticscash.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.CoroutineName
import kotlinx.coroutines.experimental.runBlocking
import statistics_cash.fedka27.github.com.statisticscash.R
import statistics_cash.fedka27.github.com.statisticscash.data.api.Api
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.di.ComponentProvider
import statistics_cash.fedka27.github.com.statisticscash.ui.main.MainContract
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    @Inject
    lateinit var api: Api


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ComponentProvider.Main.getMainSubcomponent(this).inject(this)

        setContentView(R.layout.activity_main)

        initListeners()

        test()
    }

    private fun test() = runBlocking(CoroutineName("main")) {


    }

    private fun initListeners() {
        loadButton.setOnClickListener {
            presenter.onLoadPressed()
        }
        insertRandom.setOnClickListener {
            presenter.insertNote(Note.createRandom())
        }
    }

    override fun setText(text: String) {
        helloTextView.text = text
    }

    override fun onError(message: String?) {
        helloTextView.text = message
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }
}
