package online.jutter.smartsity

import androidx.fragment.app.Fragment
import online.jutter.smartsity.ui.auth.login.LoginFragment
import online.jutter.smartsity.ui.auth.pincode.PinFragment
import online.jutter.smartsity.ui.global.FlowGlobalFragment
import online.jutter.smartsity.ui.leaderboard.FlowLeaderboardFragment
import online.jutter.smartsity.ui.leaderboard.LeaderboardFragment
import online.jutter.smartsity.ui.main.FlowMainFragment
import online.jutter.smartsity.ui.main.MainContainerFragment
import online.jutter.smartsity.ui.map.FlowMapFragment
import online.jutter.smartsity.ui.news.FlowNewsFragment
import online.jutter.smartsity.ui.news.NewsFragment
import online.jutter.smartsity.ui.profile.FlowProfileFragment
import online.jutter.smartsity.ui.profile.ProfileFragment
import online.jutter.smartsity.ui.schedule.FlowScheduleFragment
import online.jutter.smartsity.ui.schedule.ScheduleFragment
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
        override fun getFragment() = PinFragment.createInstance(number)
    }

    object FlowMain : SupportAppScreen() {
        override fun getFragment() = FlowMainFragment()
    }

    object MainContainer : SupportAppScreen() {
        override fun getFragment() = MainContainerFragment.create()
    }

    /** Новости - роутер */

    object FlowNews : SupportAppScreen() {
        override fun getFragment(): Fragment = FlowNewsFragment()
    }

    object News : SupportAppScreen() {
        override fun getFragment(): Fragment = NewsFragment()
    }

    /** Расписание - роутер */

    object FlowSchedule: SupportAppScreen() {
        override fun getFragment(): Fragment = FlowScheduleFragment()
    }

    object Schedule: SupportAppScreen() {
        override fun getFragment(): Fragment = ScheduleFragment()
    }

    /** Карта - роутер */

    object FlowMap: SupportAppScreen() {
        override fun getFragment(): Fragment = FlowMapFragment()
    }

    object Map: SupportAppScreen() {
        override fun getFragment(): Fragment = ScheduleFragment()
    }

    /** Победители - роутер */

    object FlowLeaderboard: SupportAppScreen() {
        override fun getFragment(): Fragment = FlowLeaderboardFragment()
    }

    object Leaderboard: SupportAppScreen() {
        override fun getFragment(): Fragment = LeaderboardFragment()
    }

    /** Профиль - роутер */

    object FlowProfile: SupportAppScreen() {
        override fun getFragment(): Fragment = FlowProfileFragment()
    }

    object Profile: SupportAppScreen() {
        override fun getFragment(): Fragment = ProfileFragment()
    }
}