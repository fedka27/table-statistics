package statistics_cash.fedka27.github.com.statisticscash.data.database.dbo.note

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import statistics_cash.fedka27.github.com.statisticscash.extentions.toDateTimeFormat
import java.util.*

@Entity(tableName = "notes")
class NoteDbo(
        @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Long = 0,
        @ColumnInfo(name = "title") var title: String,
        @ColumnInfo(name = "description") var description: String,
        @ColumnInfo(name = "createdAt") val createdAt: String = Date().toDateTimeFormat(),
        @ColumnInfo(name = "updatedAt") var updateAt: String? = null
) {

    companion object {
        fun createRandom(): NoteDbo {
            val random = Random()
            return NoteDbo(
                    title = "Title #${random.nextInt(10)}",
                    description = "Description #${random.nextInt(10)}"
            )
        }
    }
}