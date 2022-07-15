package online.jutter.smartsity.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserLocal(
    val id: Long,
    val firstname: String,
    val lastname: String,
    val phone: String,
    val city: String,
    val avatar: String
) : Parcelable
