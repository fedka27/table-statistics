package statistics_cash.fedka27.github.com.statisticscash.data.api

import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import statistics_cash.fedka27.github.com.statisticscash.data.api.requests.SignInRequest
import statistics_cash.fedka27.github.com.statisticscash.data.api.responses.SignInResponse

interface Api {

    /*User*/
    @POST("api/user/sign-in")
    fun signIn(@Body signInRequest: SignInRequest): Deferred<Response<SignInResponse>>

}