package online.jutter.smartsity.ui.profile.findgroup

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_room.view.*
import online.jutter.roadmapview.data.models.map.RMRoom
import online.jutter.smartsity.R
import online.jutter.smartsity.domain.models.TeamLocal
import java.security.acl.Group

class GroupsAdapter(
    val teamClick: (TeamLocal)->Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = listOf<TeamLocal>()
    private var originalList = listOf<TeamLocal>()
    private var filter: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_group, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemHolder) holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setFilter(filter: String) {
        this.filter = filter
        this.list = originalList.filter { it.name.contains(filter, true) }
        notifyDataSetChanged()
    }

    fun addData(groups: List<TeamLocal>) {
        this.list = groups
        this.originalList = list.map { it.copy() }
        notifyDataSetChanged()
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(team: TeamLocal) {
            with(itemView) {
                tvTitle.text = team.name
                tvNameAddress.text = "Участников: ${team.participants.size}"
                mainCard.setOnClickListener {
                    teamClick(team)
                }
            }
        }
    }
}