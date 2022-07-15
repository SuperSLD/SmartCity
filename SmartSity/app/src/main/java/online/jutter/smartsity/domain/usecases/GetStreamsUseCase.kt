package online.jutter.smartsity.domain.usecases

import online.jutter.smartsity.data.net.models.StreamResponse
import online.jutter.smartsity.data.net.retrofit.ApiService
import online.jutter.smartsity.domain.models.StreamLocal
import online.jutter.smartsity.domain.models.schedule.ScheduleDateLocal
import online.jutter.smartsity.domain.models.schedule.ScheduleTimeLocal
import online.jutter.supersld.extensions.withIO
import java.security.InvalidParameterException

class GetStreamsUseCase(private val service: ApiService) {

    suspend operator fun invoke(): List<StreamLocal> {
        val data = withIO { service.getStreams() }
        return if (data.success) data.data.map { it.toLocal() }
        else throw InvalidParameterException(data.message)
    }

}
