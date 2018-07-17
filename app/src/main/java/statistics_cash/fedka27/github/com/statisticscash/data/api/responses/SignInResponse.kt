package statistics_cash.fedka27.github.com.statisticscash.data.api.responses

import com.google.gson.annotations.SerializedName
import statistics_cash.fedka27.github.com.statisticscash.data.dto.User
import java.io.Serializable

data class SignInResponse(
        @SerializedName("user") val user: User,
        @SerializedName("accessToken") val accessToken: String
) : ResultResponse(), Serializable