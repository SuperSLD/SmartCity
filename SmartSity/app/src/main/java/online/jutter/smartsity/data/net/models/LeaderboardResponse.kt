package online.jutter.smartsity.data.net.models

data class LeaderboardResponse(
    val competition: CompetitionResponse,
    val list: List<MemberResponse>
)