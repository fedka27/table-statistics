package statistics_cash.fedka27.github.com.statisticscash.data.database.notes

import android.arch.persistence.room.*
import statistics_cash.fedka27.github.com.statisticscash.data.database.dto.note.NoteDto

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<NoteDto>

    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    fun putNote(noteDto: NoteDto)

    @Delete
    fun deleteNote(noteDto: NoteDto)

}