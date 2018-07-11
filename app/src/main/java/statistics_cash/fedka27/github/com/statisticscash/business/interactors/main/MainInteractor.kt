package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import kotlinx.coroutines.experimental.Job

interface MainInteractor {

    fun testAsync(onNext: (String) -> Unit = {},
                  success: (String) -> Unit = {},
                  error: (String) -> Unit = {}
    ): Job
}