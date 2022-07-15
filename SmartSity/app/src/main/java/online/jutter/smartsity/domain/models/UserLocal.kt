package online.jutter.smartsity.domain.models

data class UserLocal(
    val id: Long,
    val firstname: String,
    val lastname: String,
    val phone: String,
    val city: String,
    val avatar: String
)
