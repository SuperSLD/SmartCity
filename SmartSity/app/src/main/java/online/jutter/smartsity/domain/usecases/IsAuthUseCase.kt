package online.jutter.smartsity.domain.usecases

import android.content.Context
import online.jutter.smartsity.data.getPhone
import online.jutter.smartsity.data.savePhone

class IsAuthUseCase(
    val context: Context
) {

    operator fun invoke(): Boolean {
        return context.getPhone()?.isNotEmpty() ?: false
    }
}