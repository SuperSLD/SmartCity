package online.jutter.smartsity.data.net.models

data class DataWrapper<T>(
    val success: Boolean,
    val data: T,
    val message: String
)
