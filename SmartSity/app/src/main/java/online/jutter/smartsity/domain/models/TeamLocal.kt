package online.jutter.smartsity.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import online.jutter.smartsity.data.net.models.UserResponse

@Parcelize
data class TeamLocal(
    val id: Long,
    val name: String,
    val password: String,
    val participants: List<UserLocal>,
    val captainId: Long
) : Parcelable
