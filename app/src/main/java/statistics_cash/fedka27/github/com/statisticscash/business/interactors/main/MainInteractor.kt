package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.data.dto.NoteInsertResult

interface MainInteractor {

    suspend fun getNotes(): List<Note>

    suspend fun insert(note: Note): NoteInsertResult

    /**
     * Cancel all jobs
     * */
    fun cancel()
}