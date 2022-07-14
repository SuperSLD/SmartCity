package online.jutter.smartsity.ui.leaderboard.holders

import kotlinx.android.synthetic.main.item_leaderboard_holder.view.*
import android.annotation.SuppressLint
import android.view.View
import online.jutter.diffadapter2.base.DFBaseHolder
import online.jutter.diffadapter2.base.HolderLayout
import online.jutter.smartsity.R
import online.jutter.smartsity.domain.controllers.models.LeaderBoard
import online.jutter.smartsity.domain.controllers.models.UserResult

@SuppressLint("NonConstantResourceId")
@HolderLayout(layout = R.layout.item_leaderboard_holder)
class LeaderBoardHolder(itemView: View) : DFBaseHolder<LeaderBoard>(itemView) {

    @SuppressLint("SetTextI18n")
    override fun bind(item: LeaderBoard) {

        with(itemView) {
           tvCompetitionName.text = item.name
           tvPlace.text = item.place
           tvFirstPlaceName.text = item.users[0].userName

           if (item.users.find { it.place == 1 } == null) {
               tvSecondPlaceName.text = item.users[1].userName
           } else secondPlaceLayout.visibility = View.GONE

            if (item.users.find { it.place == 2 } == null) {
                tvThirdPlaceName.text = item.users[2].userName
            } else thirdPlaceLayout.visibility = View.GONE

        }
    }

}