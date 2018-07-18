package statistics_cash.fedka27.github.com.statisticscash.business.interactors.main

import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note
import statistics_cash.fedka27.github.com.statisticscash.data.dto.NoteInsertResult
import statistics_cash.fedka27.github.com.statisticscash.data.dto.User
import statistics_cash.fedka27.github.com.statisticscash.data.dto.sign_in.SignIn

interface MainInteractor {

    suspend fun getNotes(): List<Note>

    suspend fun insert(note: Note): NoteInsertResult

    //todo move to own interactor
    @Throws
    suspend fun signIn(signIn: SignIn): User

    /**
     * Cancel all jobs
     * */
    fun cancel()
}