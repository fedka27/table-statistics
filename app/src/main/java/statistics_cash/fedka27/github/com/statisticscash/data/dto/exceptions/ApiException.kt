package statistics_cash.fedka27.github.com.statisticscash.data.dto.exceptions

import com.google.gson.annotations.SerializedName

data class ApiException(
        @SerializedName("name") val name: String?,
        @SerializedName("message") val message: String?,
        @SerializedName("code") val code: Int?,
        @SerializedName("type") val type: String?
)