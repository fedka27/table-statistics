package statistics_cash.fedka27.github.com.statisticscash.data.database.notes

import android.arch.persistence.room.*
import statistics_cash.fedka27.github.com.statisticscash.data.database.dbo.note.NoteDbo

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<NoteDbo>

    @Query("SELECT COUNT(*) FROM notes")
    fun getNotesSize(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun putNote(noteDbo: NoteDbo)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(noteDbo: NoteDbo)

    @Delete
    fun deleteNote(noteDbo: NoteDbo)

}