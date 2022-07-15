package online.jutter.smartsity.domain.models

import online.jutter.smartsity.data.net.models.UserResponse

data class TeamLocal(
    val id: String,
    val name: String,
    val password: String,
    val participants: List<UserLocal>,
    val captainId: Long
)
