package statistics_cash.fedka27.github.com.statisticscash.data.dto.note

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "notes")
class NoteDto(
        @PrimaryKey val id: Long,
        @ColumnInfo(name = "title") var title: String,
        @ColumnInfo(name = "description") var description: String
)