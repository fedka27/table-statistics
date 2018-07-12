package statistics_cash.fedka27.github.com.statisticscash.data.database.notes

import android.arch.persistence.room.*
import statistics_cash.fedka27.github.com.statisticscash.data.dto.note.NoteDto

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<NoteDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun putNote(noteDto: NoteDto)

    @Delete
    fun deleteNote(noteDto: NoteDto)

}