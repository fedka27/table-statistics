package statistics_cash.fedka27.github.com.statisticscash.data.api.responses

import com.google.gson.annotations.SerializedName
import statistics_cash.fedka27.github.com.statisticscash.data.dto.exceptions.ApiException


open class BaseResponse(@SerializedName("success") val success: Boolean = false,
                        @SerializedName("exception") val exception: ApiException? = null) {

}