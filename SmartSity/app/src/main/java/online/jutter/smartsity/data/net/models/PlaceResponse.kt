package online.jutter.smartsity.data.net.models

import online.jutter.smartsity.domain.models.PlaceLocal

data class PlaceResponse(
    val id: Long,
    val name: String,
    val address: String,
    val x: Double,
    val y: Double,
    val structName: String,
    val floor: Int?
) {

    fun toLocal() = PlaceLocal(
        id = id,
        name = name,
        address = address,
        x = x,
        y = y,
        structName = structName,
        floor = floor
    )

}
