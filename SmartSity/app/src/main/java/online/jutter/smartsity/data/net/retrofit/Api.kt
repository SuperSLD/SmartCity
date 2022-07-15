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

    @GET("teams/all")
    suspend fun getTeams(): DataWrapper<List<TeamResponse>>

    @GET("competitions/join/{phone}/{id}")
    suspend fun joinToCompetition(
        @Path("phone") phone: String,
        @Path("id") id: Int
    ): DataWrapper<Int>

    @GET("teams/create/{phone}/{name}/{code}")
    suspend fun createTeam(
        @Path("phone") phone: String,
        @Path("name") name: String,
        @Path("code") code: String,
    ): DataWrapper<Int>
}
