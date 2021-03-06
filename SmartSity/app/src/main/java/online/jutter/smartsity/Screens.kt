package online.jutter.smartsity

import androidx.fragment.app.Fragment
import online.jutter.smartsity.data.net.models.CompetitionResponse
import online.jutter.smartsity.data.net.models.LeaderboardResponse
import online.jutter.smartsity.domain.models.NewsLocal
import online.jutter.smartsity.domain.models.schedule.ScheduleLocal
import online.jutter.smartsity.data.net.models.MemberResponse
import online.jutter.smartsity.domain.models.TeamLocal
import online.jutter.smartsity.ui.auth.login.LoginFragment
import online.jutter.smartsity.ui.auth.pincode.PinFragment
import online.jutter.smartsity.ui.auth.profile_filling.ProfileFillingFragment
import online.jutter.smartsity.ui.global.FlowGlobalFragment
import online.jutter.smartsity.ui.leaderboard.FlowLeaderboardFragment
import online.jutter.smartsity.ui.leaderboard.LeaderboardFragment
import online.jutter.smartsity.ui.leaderboard.info.LeaderboardInfoFragment
import online.jutter.smartsity.ui.main.FlowMainFragment
import online.jutter.smartsity.ui.main.MainContainerFragment
import online.jutter.smartsity.ui.map.FlowMapFragment
import online.jutter.smartsity.ui.map.MapFragment
import online.jutter.smartsity.ui.map.navigation.NavigationFragment
import online.jutter.smartsity.ui.map.selectroom.SelectRoomFragment
import online.jutter.smartsity.ui.news.FlowNewsFragment
import online.jutter.smartsity.ui.news.NewsFragment
import online.jutter.smartsity.ui.news.detail.NewsDetailFragment
import online.jutter.smartsity.ui.news.streams.StreamsFragment
import online.jutter.smartsity.ui.profile.FlowProfileFragment
import online.jutter.smartsity.ui.profile.ProfileFragment
import online.jutter.smartsity.ui.profile.findgroup.FindGroupFragment
import online.jutter.smartsity.ui.profile.findgroup.createteam.CreateTeamFragment
import online.jutter.smartsity.ui.profile.findgroup.jointeam.JoinTeamFragment
import online.jutter.smartsity.ui.schedule.FlowScheduleFragment
import online.jutter.smartsity.ui.schedule.ScheduleFragment
import online.jutter.smartsity.ui.schedule.competitiondetail.CompetitionDetailFragment
import online.jutter.smartsity.ui.schedule.successjoin.SuccessFragment
import online.jutter.smartsity.ui.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import java.lang.reflect.Member

object Screens {

    /** ???????????????????? ???????????? */

    object FlowGlobal : SupportAppScreen() {
        override fun getFragment() = FlowGlobalFragment()
    }

    object Splash : SupportAppScreen() {
        override fun getFragment() = SplashFragment()
    }
    
    object Login : SupportAppScreen() {
        override fun getFragment() = LoginFragment()
    }

    object Registration : SupportAppScreen() {
        override fun getFragment() = ProfileFillingFragment()
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

    /** ?????????????? - ???????????? */

    object FlowNews : SupportAppScreen() {
        override fun getFragment(): Fragment = FlowNewsFragment()
    }

    object News : SupportAppScreen() {
        override fun getFragment(): Fragment = NewsFragment()
    }

    data class NewsDetail(val news: NewsLocal) : SupportAppScreen() {
        override fun getFragment(): Fragment = NewsDetailFragment.create(news)
    }

    object Streams : SupportAppScreen() {
        override fun getFragment(): Fragment = StreamsFragment()
    }

    /** ???????????????????? - ???????????? */

    object FlowSchedule: SupportAppScreen() {
        override fun getFragment(): Fragment = FlowScheduleFragment()
    }

    object Schedule: SupportAppScreen() {
        override fun getFragment(): Fragment = ScheduleFragment()
    }

    data class CompetitionDetail(
        val scheduleLocal: ScheduleLocal
    ): SupportAppScreen() {
        override fun getFragment() = CompetitionDetailFragment.createInstance(scheduleLocal)
    }

    object Success: SupportAppScreen() {
        override fun getFragment() = SuccessFragment()
    }

    /** ?????????? - ???????????? */

    object FlowMap: SupportAppScreen() {
        override fun getFragment(): Fragment = FlowMapFragment()
    }

    object Map: SupportAppScreen() {
        override fun getFragment(): Fragment = MapFragment()
    }

    object Navigation : SupportAppScreen() {
        override fun getFragment() = NavigationFragment()
    }

    object SelectRoom : SupportAppScreen() {
        override fun getFragment() = SelectRoomFragment()
    }

    /** ???????????????????? - ???????????? */

    object FlowLeaderboard: SupportAppScreen() {
        override fun getFragment(): Fragment = FlowLeaderboardFragment()
    }

    object Leaderboard: SupportAppScreen() {
        override fun getFragment(): Fragment = LeaderboardFragment()
    }

    data class LeaderboardInfo(val leaderboard: LeaderboardResponse) : SupportAppScreen() {
        override fun getFragment() = LeaderboardInfoFragment.createInstance(leaderboard)
    }

    /** ?????????????? - ???????????? */

    object FlowProfile: SupportAppScreen() {
        override fun getFragment(): Fragment = FlowProfileFragment()
    }

    object Profile: SupportAppScreen() {
        override fun getFragment(): Fragment = ProfileFragment()
    }

    object FindGroup: SupportAppScreen() {
        override fun getFragment() = FindGroupFragment()
    }

    object CreateTeam: SupportAppScreen() {
        override fun getFragment() = CreateTeamFragment()
    }

    data class JoinTeam(val team: TeamLocal): SupportAppScreen() {
        override fun getFragment() = JoinTeamFragment.create(team)
    }
}
