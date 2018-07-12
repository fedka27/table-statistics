package statistics_cash.fedka27.github.com.statisticscash.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import statistics_cash.fedka27.github.com.statisticscash.data.database.dbo.note.NoteDbo
import statistics_cash.fedka27.github.com.statisticscash.data.database.notes.NotesDao

@Database(
        entities = [
            NoteDbo::class
        ],
        version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNotesDao(): NotesDao
}