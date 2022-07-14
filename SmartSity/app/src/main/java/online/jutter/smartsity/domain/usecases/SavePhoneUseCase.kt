package online.jutter.smartsity.domain.usecases

import android.content.Context
import online.jutter.smartsity.data.savePhone

class SavePhoneUseCase(
    val context: Context
) {

    operator fun invoke(phone: String) {
        context.savePhone(phone)
    }
}