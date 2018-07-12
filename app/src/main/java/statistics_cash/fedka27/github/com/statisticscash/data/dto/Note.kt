package statistics_cash.fedka27.github.com.statisticscash.data.dto

import statistics_cash.fedka27.github.com.statisticscash.extentions.dateTimePattern
import statistics_cash.fedka27.github.com.statisticscash.extentions.toDateTimeFormat
import statistics_cash.fedka27.github.com.statisticscash.extentions.toDateWithFormat
import statistics_cash.fedka27.github.com.statisticscash.extentions.toDisplayFormat
import java.util.*

class Note(
        val id: Long = 0,
        var title: String,
        var description: String,
        val createdAt: String,
        var updatedAt: String?
) {

    fun isUpdated(): Boolean = updatedAt != null

    fun getUpdatedDateTime(): String? = updatedAt?.toDateWithFormat(dateTimePattern)?.toDisplayFormat()

    fun getCreatedDateTime(): String? = createdAt.toDateWithFormat(dateTimePattern)?.toDisplayFormat()

    //todo remove
    companion object {
        fun createRandom(): Note {
            val random = Random()
            return Note(
                    title = "Title #${random.nextInt(10)}",
                    description = "Description #${random.nextInt(10)}",
                    createdAt = Date().toDateTimeFormat(),
                    updatedAt = null
            )
        }
    }
}