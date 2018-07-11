package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class MainInteractorImpl : MainInteractor {

    override fun testAsync(onNext: (String) -> Unit,
                           success: (String) -> Unit,
                           error: (String) -> Unit
    ): Job {
        return launch(
                context = UI,
                block = {
                    var seconds = 0

                    while (seconds <= 60) {
                        onNext.invoke("$seconds")

                        delay(1000)

                        seconds++

                    }

                    success.invoke("$seconds")
                })
    }
}