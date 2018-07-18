package statistics_cash.fedka27.github.com.statisticscash.business.repositories.user

import statistics_cash.fedka27.github.com.statisticscash.data.api.Api
import statistics_cash.fedka27.github.com.statisticscash.data.api.requests.SignInRequest
import statistics_cash.fedka27.github.com.statisticscash.data.dto.User
import statistics_cash.fedka27.github.com.statisticscash.data.dto.sign_in.SignIn
import statistics_cash.fedka27.github.com.statisticscash.data.mapper.api.ApiMapper

class UserRepositoryImpl(
        private val api: Api,
        private val apiMapper: ApiMapper
) : UserRepository {

    override suspend fun signIn(signIn: SignIn): User {
        val signInRequest = with(signIn) {
            SignInRequest(email, password)
        }
        val response = apiMapper.mapResponse(api.signIn(signInRequest).await())
        //todo save token

        return response.user
    }
}