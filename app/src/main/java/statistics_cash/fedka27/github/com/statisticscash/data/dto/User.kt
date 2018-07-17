package statistics_cash.fedka27.github.com.statisticscash.data.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User constructor(
        id: Long,
        @SerializedName("fullName") val fullName: String? = null,
        @SerializedName("role") val position: String? = null,
        @SerializedName("email") val email: String? = null,
        @SerializedName("photo") val photo: String? = null
) : Item(id), Serializable {
}