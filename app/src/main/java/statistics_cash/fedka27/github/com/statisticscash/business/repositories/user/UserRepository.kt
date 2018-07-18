package statistics_cash.fedka27.github.com.statisticscash.business.repositories.user

import statistics_cash.fedka27.github.com.statisticscash.data.dto.User
import statistics_cash.fedka27.github.com.statisticscash.data.dto.sign_in.SignIn

interface UserRepository {
    suspend fun signIn(signIn: SignIn): User
}