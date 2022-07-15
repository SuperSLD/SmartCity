package online.jutter.smartsity.data.net.retrofit

import online.jutter.smartsity.data.net.models.CreateTeamBody
import online.jutter.smartsity.data.net.models.JoinTeamBody

class ApiService(private val api: Api) {

    suspend fun getScheduleList() = api.getSchedule()

    suspend fun getLeaderBoardList() = api.getLeaderBoard()

    suspend fun getUserProfile(phone: String) = api.getProfile(phone)

    suspend fun getNews() = api.getNews()

    suspend fun getTeams() = api.getTeams()

    suspend fun joinToCompetition(phone: String, id: Int) = api.joinToCompetition(phone, id)

    suspend fun createTeam(
        phone: String,
        name: String,
        code: String,
    ) = api.createTeam(CreateTeamBody(phone, name, code))

    suspend fun joinTeam(
        phone: String,
        teamId: Long,
        code: String
    ) = api.joinTeam(JoinTeamBody(phone, teamId, code))

    suspend fun getStreams() = api.getStreams()
}
