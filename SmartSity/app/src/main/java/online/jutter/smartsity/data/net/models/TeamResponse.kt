package online.jutter.smartsity.data.net.models

import online.jutter.smartsity.domain.models.TeamLocal

data class TeamResponse(
    val id: String,
    val name: String,
    val password: String,
    val captainId: Long,
    val users: List<UserResponse>,
) {

    fun toLocal() = TeamLocal(
        id = id,
        name = name,
        password = password,
        participants = users.map { it.toLocal() },
        captainId = captainId
    )

}
