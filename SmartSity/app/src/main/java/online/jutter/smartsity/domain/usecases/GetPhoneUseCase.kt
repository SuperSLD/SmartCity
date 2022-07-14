package online.jutter.smartsity.domain.usecases

import android.content.Context
import online.jutter.smartsity.data.getPhone
import online.jutter.smartsity.data.savePhone

class GetPhoneUseCase(
    val context: Context
) {

    operator fun invoke(): String? {
        return context.getPhone()
    }
}