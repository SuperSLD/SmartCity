package online.jutter.smartsity.domain.usecases

import online.jutter.smartsity.data.net.retrofit.ApiService
import online.jutter.smartsity.domain.models.schedule.ScheduleDateLocal
import online.jutter.smartsity.domain.models.schedule.ScheduleTimeLocal
import online.jutter.supersld.extensions.withIO
import java.security.InvalidParameterException

class GetScheduleListUseCase(private val service: ApiService) {

    suspend operator fun invoke(): List<ScheduleDateLocal> {
        val data = withIO { service.getScheduleList() }
        return if (data.success) data.data.map { dateEntity ->
            ScheduleDateLocal(
                date = dateEntity.key,
                events = dateEntity.value.map { timeEntity ->
                    ScheduleTimeLocal(
                        time = timeEntity.key,
                        scheduleList = timeEntity.value.map { it.toLocal() }
                    )
                }
            )
        } else throw InvalidParameterException(data.message)
    }

}
