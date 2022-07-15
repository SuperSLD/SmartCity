package online.jutter.smartsity.domain.usecases

import android.security.keystore.UserNotAuthenticatedException
import online.jutter.smartsity.data.net.retrofit.ApiService
import online.jutter.smartsity.domain.models.NewsLocal
import online.jutter.smartsity.domain.models.ProfileLocal
import online.jutter.smartsity.domain.models.TeamLocal
import online.jutter.supersld.extensions.withIO
import java.security.InvalidParameterException

class GetTeamsUseCase(private val service: ApiService) {

    suspend operator fun invoke(): List<TeamLocal> {
        val data = withIO { service.getTeams() }
        return if (data.success) data.data.map { it.toLocal() }
        else throw InvalidParameterException(data.message)
    }

}
