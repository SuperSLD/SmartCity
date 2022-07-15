package online.jutter.smartsity.data.net.models

data class CompetitionResponse(
    val id: Long,
    val datetime: String,
    val place: PlaceResponse,
    val day: String,
    val time: String,
    val list: MemberResponse,
    val sport: SportResponse
)
