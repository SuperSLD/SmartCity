package online.jutter.smartsity.ui.profile.findgroup.jointeam

import com.arellomobile.mvp.MvpView
import online.jutter.smartsity.domain.models.TeamLocal

interface JoinTeamView : MvpView {

    fun showTeam(team: TeamLocal)

}
