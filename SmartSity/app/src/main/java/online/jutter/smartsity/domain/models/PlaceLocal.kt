package online.jutter.smartsity.domain.models

data class PlaceLocal(
    val id: Long,
    val name: String,
    val address: String,
    val x: Double,
    val y: Double,
    val structName: String,
    val floor: Int?
)
