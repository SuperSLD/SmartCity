package online.jutter.smartsity.domain.usecases

import android.security.keystore.UserNotAuthenticatedException
import online.jutter.smartsity.data.net.retrofit.ApiService
import online.jutter.supersld.extensions.withIO
import java.security.InvalidParameterException

class JoinTeamUseCase(
    private val service: ApiService,
    private val getPhoneUseCase: GetPhoneUseCase
) {

    suspend operator fun invoke(teamId: Long, code: String): Int {
        val phone = getPhoneUseCase()
        phone?.let {
            val data = withIO { service.joinTeam(phone, teamId, code) }
            return if (data.success) 0
            else throw InvalidParameterException(data.message)
        } ?: throw UserNotAuthenticatedException()
    }

}
