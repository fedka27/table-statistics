package statistics_cash.fedka27.github.com.statisticscash.data.mapper.dto

import statistics_cash.fedka27.github.com.statisticscash.data.database.dbo.note.NoteDbo
import statistics_cash.fedka27.github.com.statisticscash.data.dto.Note

class NoteMapper : DtoMapper<NoteDbo, Note> {
    override fun map(data: NoteDbo): Note {
        return data.let {
            Note(
                    it.id,
                    it.title,
                    it.description,
                    it.createdAt,
                    it.updateAt
            )
        }
    }

    override fun mapRevert(data: Note): NoteDbo {
        return data.let {
            NoteDbo(
                    it.id,
                    it.title,
                    it.description,
                    it.createdAt,
                    it.updatedAt
            )
        }
    }
}