package online.jutter.smartsity.data.net.models

import online.jutter.smartsity.domain.models.StreamLocal

data class StreamResponse(
    val id: Long,
    val name: String,
    val description: String,
    val link: String,
    val preview: String
) {

    fun toLocal() = StreamLocal(
        id = id,
        name = name,
        description = description,
        link = link,
        preview = preview
    )

}
