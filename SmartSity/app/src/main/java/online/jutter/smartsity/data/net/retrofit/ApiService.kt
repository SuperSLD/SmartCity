package online.jutter.smartsity.data.net.retrofit

class ApiService(private val api: Api) {

    suspend fun getScheduleList() = api.getSchedule()

}
