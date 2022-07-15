package online.jutter.smartsity.domain.usecases

import online.jutter.smartsity.data.net.models.LeaderboardResponse
import online.jutter.smartsity.data.net.retrofit.ApiService
import online.jutter.supersld.extensions.withIO
import java.security.InvalidParameterException

class GetLeaderBoardUserCase(private val service: ApiService) {
    suspend operator fun invoke(): List<LeaderboardResponse> {
        val data = withIO { service.getLeaderBoardList() }
        return if (data.success) {
            return data.data
        } else throw InvalidParameterException(data.message)
    }
}