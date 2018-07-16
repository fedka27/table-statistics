package statistics_cash.fedka27.github.com.statisticscash.data.dto

import java.io.Serializable

data class NoteInsertResult(
        val note: Note,
        val sizeOfNotes: Int
) : Serializable