package online.jutter.smartsity.domain.usecases

import android.security.keystore.UserNotAuthenticatedException
import online.jutter.smartsity.data.net.retrofit.ApiService
import online.jutter.smartsity.domain.models.ProfileLocal
import online.jutter.supersld.extensions.withIO
import java.security.InvalidParameterException

class CheckUserRegisteredUseCase (
    private val service: ApiService,
    private val getPhoneUseCase: GetPhoneUseCase
) {

    suspend operator fun invoke(): Boolean {
        val phone = getPhoneUseCase()
        phone?.let {
            val data = withIO { service.getUserProfile(it) }
            return data.success
        } ?: throw UserNotAuthenticatedException()
    }
}
