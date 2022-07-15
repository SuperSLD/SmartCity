package online.jutter.smartsity.data.net.retrofit

import online.jutter.smartsity.data.net.models.*
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("competitions/all")
    suspend fun getSchedule(): DataWrapper<HashMap<String, HashMap<String, MutableList<ScheduleResponse>>>>

    @GET("leaderboard/all")
    suspend fun getLeaderBoard(): DataWrapper<List<LeaderboardResponse>>

    @GET("users/get/{phone}")
    suspend fun getProfile(@Path("phone") phone: String): DataWrapper<ProfileResponse>

    @GET("news/all")
    suspend fun getNews(): DataWrapper<List<NewsResponse>>

    @GET("competitions/join/{phone}/{id}")
    suspend fun joinToCompetition(
        @Path("phone") phone: String,
        @Path("id") id: Int
    ): DataWrapper<Int>

    @GET("streams/all")
    suspend fun getStreams(): DataWrapper<List<StreamResponse>>
}
