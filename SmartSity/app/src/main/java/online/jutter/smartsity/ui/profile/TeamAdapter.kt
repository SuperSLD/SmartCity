package online.jutter.smartsity.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import online.jutter.smartsity.databinding.ItemTeamBinding

class TeamAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TeamViewHolder(
            ItemTeamBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TeamViewHolder).bind()
    }

    override fun getItemCount(): Int {
        return 0
    }

    inner class TeamViewHolder(binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            //TODO
        }

    }

}
