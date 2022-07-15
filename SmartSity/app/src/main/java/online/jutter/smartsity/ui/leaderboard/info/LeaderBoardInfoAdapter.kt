package online.jutter.smartsity.ui.leaderboard.info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_member.view.*
import online.jutter.smartsity.R
import online.jutter.smartsity.data.net.models.MemberResponse

class LeaderBoardInfoAdapter(
    private val memberList: MutableList<MemberResponse> = mutableListOf()
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_member, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        memberList[position].let { (holder as LeaderBoardInfoAdapter.ItemViewHolder).bind(it) }
    }

    override fun getItemCount(): Int {
        return memberList.size
    }

    fun addAll(newItems: MutableList<MemberResponse>) {
        memberList.clear()
        memberList.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: MemberResponse) {
            with(itemView) {
                tvPlace.text = "#${item.rank}"
                tvName.text = item.name
            }
        }

    }
}