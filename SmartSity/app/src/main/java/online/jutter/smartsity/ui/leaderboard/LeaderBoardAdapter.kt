package online.jutter.smartsity.ui.leaderboard

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_leaderboard_holder.view.*
import online.jutter.smartsity.R
import online.jutter.smartsity.data.net.models.LeaderboardResponse
import online.jutter.smartsity.domain.models.schedule.ScheduleDateLocal

class LeaderBoardAdapter(
    private val leaderBoardList: MutableList<LeaderboardResponse> = mutableListOf()

 ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_leaderboard_holder, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        leaderBoardList[position].let { (holder as ItemViewHolder).bind(it) }
    }

    fun addAll(newItems: List<LeaderboardResponse>) {
        leaderBoardList.clear()
        leaderBoardList.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return leaderBoardList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: LeaderboardResponse) {
            with(itemView) {
                tvCompetitionName.text = item.competition.sport.name
                tvPlace.text = item.competition.place.name
                tvFirstPlaceName.text = item.list[0].name

                if (item.list.find { it.rank == 2 } == null) {
                    secondPlaceLayout.visibility = View.GONE
                } else tvSecondPlaceName.text = item.list[1].name


                if (item.list.find { it.rank == 3 } == null) {
                    thirdPlaceLayout.visibility = View.GONE
                } else tvThirdPlaceName.text = item.list[2].name


            }
        }

    }
}

