package online.jutter.smartsity.data.net.models

import online.jutter.smartsity.domain.models.SportLocal

data class SportResponse(
    val id: Long,
    val name: String,
    val description: String,
    val team: Boolean
) {

    fun toLocal() = SportLocal(
        id = id,
        name = name,
        description = description,
        team = team
    )

}
