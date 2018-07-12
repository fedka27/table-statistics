package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import kotlinx.coroutines.experimental.Deferred
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note

interface MainInteractor {

    fun getNotes(): Deferred<List<Note>>

    fun insert(note: Note,
               success: (Note, Int) -> Unit,
               error: (Throwable) -> Unit = {})

    /**
     * Cancel all jobs
     * */
    fun cancel()
}