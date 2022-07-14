package online.jutter.smartsity.domain.models.schedule

data class ScheduleTimeLocal(
    val time: String,
    val scheduleList: List<ScheduleLocal>
)
