package statistics_cash.fedka27.github.com.statisticscash.data.api.requests

import com.google.gson.annotations.SerializedName

data class SignInRequest(
        @SerializedName("email") val email: String,
        @SerializedName("password") val password: String
)