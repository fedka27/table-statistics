package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note

interface MainInteractor {

    fun getNotes(success: (List<Note>) -> Unit = {},
                 error: (Throwable) -> Unit = {})

    fun insert(note: Note,
               success: (Note, Int) -> Unit,
               error: (Throwable) -> Unit = {})

    /**
     * Cancel all jobs
     * */
    fun cancel()
}