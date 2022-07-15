package online.jutter.smartsity.domain.models

data class ProfileLocal(
    val user: UserLocal,
    val team: TeamLocal,
    val goldMedalsCount: Int?,
    val silverMedalsCount: Int?,
    val bronzeMedalsCount: Int?,
    val otherMedalsCount: Int?
)
