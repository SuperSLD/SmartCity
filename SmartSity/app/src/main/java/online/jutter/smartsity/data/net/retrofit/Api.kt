package online.jutter.smartsity.data.net.retrofit

import online.jutter.smartsity.data.net.models.DataWrapper
import online.jutter.smartsity.data.net.models.NewsResponse
import online.jutter.smartsity.data.net.models.ProfileResponse
import online.jutter.smartsity.data.net.models.ScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("competitions/all")
    suspend fun getSchedule(): DataWrapper<HashMap<String, HashMap<String, MutableList<ScheduleResponse>>>>

    @GET("users/get/{phone}")
    suspend fun getProfile(@Path("phone") phone: String): DataWrapper<ProfileResponse>

    @GET("news/all")
    suspend fun getNews(): DataWrapper<List<NewsResponse>>

}
