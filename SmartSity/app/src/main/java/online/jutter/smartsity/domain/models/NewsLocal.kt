package online.jutter.smartsity.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsLocal(
    val id: Long,
    val title: String,
    val text: String,
    val image: String,
    val shortText: String,
    val dateString: String
) : Parcelable
