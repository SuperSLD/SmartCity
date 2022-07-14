package online.jutter.smartsity.domain.controllers.models

data class Event(
    var id: Int,
    val title: String,
    val info: String,
    val image: String,
    val date: String
)
