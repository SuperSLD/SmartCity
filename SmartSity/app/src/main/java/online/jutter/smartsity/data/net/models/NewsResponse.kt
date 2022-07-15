package online.jutter.smartsity.data.net.models

import online.jutter.smartsity.domain.models.NewsLocal

data class NewsResponse(
    val id: Long,
    val title: String,
    val text: String,
    val image: String,
    val shortText: String,
    val dateString: String
) {

    fun toLocal() = NewsLocal(
        id = id,
        title = title,
        text = text,
        image = image,
        shortText = shortText,
        dateString = dateString
    )

}
