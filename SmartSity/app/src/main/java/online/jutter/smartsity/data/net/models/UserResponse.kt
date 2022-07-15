package online.jutter.smartsity.data.net.models

import online.jutter.smartsity.domain.models.UserLocal

data class UserResponse(
    val id: Long,
    val firstname: String,
    val lastname: String,
    val phone: String,
    val city: String,
    val avatar: String,
    val teamId: Long
) {

    fun toLocal() = UserLocal(
        id = id,
        firstname = firstname,
        lastname = lastname,
        phone = phone,
        city = city,
        avatar = avatar
    )

}
