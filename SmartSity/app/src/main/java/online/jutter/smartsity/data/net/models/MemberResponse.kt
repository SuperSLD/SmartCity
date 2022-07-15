package online.jutter.smartsity.data.net.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MemberResponse(
    val rank: Int,
    val name: String
): Parcelable
