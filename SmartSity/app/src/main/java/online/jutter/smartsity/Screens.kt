package online.jutter.smartsity

import androidx.fragment.app.Fragment
import online.jutter.smartsity.ui.auth.login.LoginFragment
import online.jutter.smartsity.ui.auth.pincode.PinFragment
import online.jutter.smartsity.ui.global.FlowGlobalFragment
import online.jutter.smartsity.ui.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    /** Глобальный роутер */

    object FlowGlobal : SupportAppScreen() {
        override fun getFragment() = FlowGlobalFragment()
    }

    object Splash : SupportAppScreen() {
        override fun getFragment() = SplashFragment()
    }

    object Login : SupportAppScreen() {
        override fun getFragment() = LoginFragment()
    }

    data class Pin(
        val number: String,
    ) : SupportAppScreen() {
        override fun getFragment() = PinFragment()
    }
}