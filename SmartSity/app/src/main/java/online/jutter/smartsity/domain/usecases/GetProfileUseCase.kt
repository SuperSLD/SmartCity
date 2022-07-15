package online.jutter.smartsity.domain.usecases

import android.security.keystore.UserNotAuthenticatedException
import online.jutter.smartsity.data.net.retrofit.ApiService
import online.jutter.smartsity.domain.models.ProfileLocal
import online.jutter.supersld.extensions.withIO
import java.security.InvalidParameterException

class GetProfileUseCase(
    private val service: ApiService,
    private val getPhoneUseCase: GetPhoneUseCase
) {

    suspend operator fun invoke(): ProfileLocal {
        val phone = getPhoneUseCase()
        phone?.let {
            val data = withIO { service.getUserProfile(it) }
            return if (data.success) data.data.toLocal()
            else throw InvalidParameterException(data.message)
        } ?: throw UserNotAuthenticatedException()
    }

}
