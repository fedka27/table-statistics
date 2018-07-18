package statistics_cash.fedka27.github.com.statisticscash.data.mapper.dto

interface DtoMapper<F, T> {
    fun map(data: F): T

    fun mapRevert(data: T): F
}