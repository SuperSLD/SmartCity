package online.jutter.smartsity.domain.models.schedule

import online.jutter.smartsity.domain.models.PlaceLocal
import online.jutter.smartsity.domain.models.SportLocal

data class ScheduleLocal(
    val id: Long,
    val place: PlaceLocal,
    val sport: SportLocal,
    val day: String,
    val time: String
)
