package online.jutter.smartsity.data.net.models

import online.jutter.smartsity.domain.models.schedule.ScheduleLocal

data class ScheduleResponse(
    val id: Long,
    val place: PlaceResponse,
    val sport: SportResponse,
    val day: String,
    val time: String
) {

    fun toLocal() = ScheduleLocal(
        id = id,
        place = place.toLocal(),
        sport = sport.toLocal(),
        day = day,
        time = time
    )

}
