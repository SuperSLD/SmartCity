package online.jutter.smartsity.ui.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_leaderboard_holder.view.*
import online.jutter.smartsity.R
import online.jutter.smartsity.domain.controllers.models.LeaderBoard

class LeaderBoardAdapter(
    private val presenter: LeaderBoardAdapter,
    recyclerView: RecyclerView,
    private val leaderBoardList: MutableList<LeaderBoard?>

 ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_leaderboard_holder, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return leaderBoardList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: LeaderBoard) {

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
}

