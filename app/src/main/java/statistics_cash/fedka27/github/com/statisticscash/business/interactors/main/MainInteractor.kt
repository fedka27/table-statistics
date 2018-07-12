package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import kotlinx.coroutines.experimental.Job
import statistics_cash.fedka27.github.com.statisticscash.data.dto.note.NoteDto

interface MainInteractor {

    /**
     * Test timer with delay
     * @param onNext - a function that returns the time in seconds on each cycle timer
     * */
    fun testAsync(onNext: (String) -> Unit = {},
                  success: (String) -> Unit = {},
                  error: (String) -> Unit = {}
    ): Job

    fun getNotes(success: (List<NoteDto>) -> Unit)

    /**
     * Cancel all jobs
     * */
    fun cancel()
}