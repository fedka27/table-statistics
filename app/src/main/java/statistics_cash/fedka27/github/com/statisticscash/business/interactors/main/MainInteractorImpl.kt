package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.cancel
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import statistics_cash.fedka27.github.com.extentions.ui

class MainInteractorImpl : MainInteractor {

    override fun testAsync(onNext: (String) -> Unit,
                           success: (String) -> Unit,
                           error: (String) -> Unit
    ): Job {
        return launch(
                context = ui,
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
                            error.invoke(e.localizedMessage)
                            return@launch
                        }
                        onNext.invoke("$seconds")

                    }

                    success.invoke("$seconds")
                })
    }
}