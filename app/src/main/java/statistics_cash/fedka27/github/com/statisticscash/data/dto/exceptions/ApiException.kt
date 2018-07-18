package statistics_cash.fedka27.github.com.statisticscash.data.dto.exceptions

import com.google.gson.annotations.SerializedName

data class ApiException(
        @SerializedName("name") val name: String? = null,
        @SerializedName("message") val message: String? = null,
        @SerializedName("code") val code: Int? = null,
        @SerializedName("type") val type: String? = null
)