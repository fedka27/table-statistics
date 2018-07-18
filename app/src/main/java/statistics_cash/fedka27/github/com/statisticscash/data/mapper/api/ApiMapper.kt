package statistics_cash.fedka27.github.com.statisticscash.data.mapper.api

import android.content.Context
import com.google.gson.Gson
import retrofit2.Response
import statistics_cash.fedka27.github.com.statisticscash.data.api.responses.BaseResponse
import statistics_cash.fedka27.github.com.statisticscash.data.dto.exceptions.ApiException
import statistics_cash.fedka27.github.com.statisticscash.data.exceptions.ApiResponseException
import statistics_cash.fedka27.github.com.statisticscash.extentions.log

class ApiMapper(
        private val context: Context
) {

    @Throws
    fun <T : BaseResponse> mapResponse(response: Response<T>): T {

        val url = response.raw().request().url().toString()


        log("url: $url")

        val baseResponse = response.body()

        if (baseResponse != null) return baseResponse

        val json = response.errorBody()?.string()

        val apiException = json?.let {
            Gson().fromJson(it, BaseResponse::class.java).exception
        } ?: ApiException(message = response.raw().message(),
                code = response.code())

        val message = apiException.message!!

        throw ApiResponseException(message)

    }
}