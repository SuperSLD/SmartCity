package online.jutter.smartsity.data.net.retrofit

class ApiService(private val api: Api) {

    suspend fun getScheduleList() = api.getSchedule()

    suspend fun getLeaderBoardList() = api.getLeaderBoard()

    suspend fun getUserProfile(phone: String) = api.getProfile(phone)
}
