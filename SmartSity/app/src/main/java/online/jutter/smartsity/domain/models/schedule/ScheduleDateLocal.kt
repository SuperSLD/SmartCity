package online.jutter.smartsity.domain.models.schedule

data class ScheduleDateLocal(
    val date: String,
    val events: List<ScheduleTimeLocal>
)
