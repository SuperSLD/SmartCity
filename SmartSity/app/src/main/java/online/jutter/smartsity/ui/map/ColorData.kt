package online.jutter.smartsity.ui.map

import android.content.Context
import android.graphics.Color
import androidx.fragment.app.Fragment
import online.jutter.roadmapview.RMColorData
import online.jutter.roadmapview.extensions.createColor
import online.jutter.smartsity.data.getIsDayTheme

fun Context.getMapColorData(
    back: Int = createColor(255, 255, 255),
    backD: Int = createColor(12, 12, 12),
): RMColorData {
    val isDay = getIsDayTheme()
    return if (isDay) {
        RMColorData(
            backColor = back,
            roadColors = listOf(
                createColor(60, 60, 60), // серый
                createColor(47, 131, 207), // красный
                createColor(47, 131, 207),  // желтый
                createColor(47, 131, 207), // зеленый
            ),
            buildingWithFloorsColor = Color.parseColor("#ABBBCC"),
        )
    } else {
        RMColorData(
            buildingColor = createColor(30, 30, 30),
            buildingWithFloorsColor = createColor(147, 117, 59),
            backColor = backD,
            navBorder = createColor(255, 255, 255),
            roadColors = listOf(
                createColor(60, 60, 60), // серый
                createColor(47, 131, 207), // красный
                createColor(47, 131, 207),  // желтый
                createColor(47, 131, 207), // зеленый
            ),
            floorBackColor = createColor(10, 10, 10),
        )
    }
}

fun Fragment.getMapColorData(
    back: Int = createColor(255, 255, 255),
    backD: Int = createColor(12, 12, 12),
) = requireContext().getMapColorData(back, backD)