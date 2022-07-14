package online.jutter.smartsity.data.net.models

import online.jutter.smartsity.domain.models.SportLocal

data class SportResponse(
    val id: Long,
    val name: String,
    val description: String
) {

    fun toLocal() = SportLocal(
        id = id,
        name = name,
        description = description
    )

}
