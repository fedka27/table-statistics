package statistics_cash.fedka27.github.com.statisticscash

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.launch
import statistics_cash.fedka27.github.com.statisticscash.business.interactors.main.MainInteractor
import statistics_cash.fedka27.github.com.statisticscash.di.ComponentProvider
import java.util.concurrent.Executor
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainInteractor: MainInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ComponentProvider.Main.getMainSubcomponent().inject(this)

        setContentView(R.layout.activity_main)

        loadWithApi()
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
                })
    }
}
