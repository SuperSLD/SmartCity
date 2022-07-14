package online.jutter.smartsity.data.net.retrofit

import online.jutter.smartsity.data.net.models.DataWrapper
import online.jutter.smartsity.data.net.models.ScheduleResponse
import retrofit2.http.GET

interface Api {

    @GET("competitions/all")
    suspend fun getSchedule(): DataWrapper<HashMap<String, HashMap<String, MutableList<ScheduleResponse>>>>

}
