package statistics_cash.fedka27.github.com.statisticscash.data.database.dto.note

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "notes")
class NoteDto(
        @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Long = 0,
        @ColumnInfo(name = "title") var title: String,
        @ColumnInfo(name = "description") var description: String
) {

    companion object {
        fun createRandom(): NoteDto {
            val random = Random()
            return NoteDto(
                    title = "Title #${random.nextInt(10)}",
                    description = "Description #${random.nextInt(10)}"
            )
        }
    }
}