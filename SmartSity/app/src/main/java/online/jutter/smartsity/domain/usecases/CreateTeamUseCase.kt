package online.jutter.smartsity.domain.usecases

import android.security.keystore.UserNotAuthenticatedException
import online.jutter.smartsity.data.net.retrofit.ApiService
import online.jutter.smartsity.domain.models.ProfileLocal
import online.jutter.supersld.extensions.withIO
import java.security.InvalidParameterException

class CreateTeamUseCase(
    private val service: ApiService,
    private val getPhoneUseCase: GetPhoneUseCase
) {

    suspend operator fun invoke(name: String, code: String): Int {
        val phone = getPhoneUseCase()
        phone?.let {
            val data = withIO { service.createTeam(phone, name, code) }
            return if (data.success) 0
            else throw InvalidParameterException(data.message)
        } ?: throw UserNotAuthenticatedException()
    }

}
