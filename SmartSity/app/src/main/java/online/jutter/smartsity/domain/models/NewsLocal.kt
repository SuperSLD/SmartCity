package online.jutter.smartsity.domain.models

data class NewsLocal(
    val id: Long,
    val title: String,
    val text: String,
    val image: String,
    val shortText: String,
    val dateString: String
)
