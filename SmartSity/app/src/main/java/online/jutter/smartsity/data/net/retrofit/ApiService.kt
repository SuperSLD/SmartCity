package online.jutter.smartsity.data.net.retrofit

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
    ) = api.createTeam(phone, name, code)
    suspend fun getStreams() = api.getStreams()
}
