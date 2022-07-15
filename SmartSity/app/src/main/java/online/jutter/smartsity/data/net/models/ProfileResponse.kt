package online.jutter.smartsity.data.net.models

import online.jutter.smartsity.domain.models.ProfileLocal

data class ProfileResponse(
    val user: UserResponse,
    val team: TeamResponse?,
    val result: List<Int>
) {

    fun toLocal() = ProfileLocal(
        user = user.toLocal(),
        team = team?.toLocal(),
        goldMedalsCount = result.getOrNull(0),
        silverMedalsCount = result.getOrNull(1),
        bronzeMedalsCount = result.getOrNull(2),
        otherMedalsCount = result.getOrNull(3)
    )

}
