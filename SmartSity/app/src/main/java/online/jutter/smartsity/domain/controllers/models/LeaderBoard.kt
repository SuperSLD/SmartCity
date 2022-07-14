package online.jutter.smartsity.domain.controllers.models

data class LeaderBoard(
    var name: String,
    var place: String,
    var users: List<UserResult>
)
