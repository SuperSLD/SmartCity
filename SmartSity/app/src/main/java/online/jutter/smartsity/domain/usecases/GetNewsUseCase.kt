package online.jutter.smartsity.domain.usecases

import android.security.keystore.UserNotAuthenticatedException
import online.jutter.smartsity.data.net.retrofit.ApiService
import online.jutter.smartsity.domain.models.NewsLocal
import online.jutter.smartsity.domain.models.ProfileLocal
import online.jutter.supersld.extensions.withIO
import java.security.InvalidParameterException

class GetNewsUseCase(private val service: ApiService) {

    suspend operator fun invoke(): List<NewsLocal> {
        val data = withIO { service.getNews() }
        return if (data.success) data.data.map { it.toLocal() }
        else throw InvalidParameterException(data.message)
    }

}
