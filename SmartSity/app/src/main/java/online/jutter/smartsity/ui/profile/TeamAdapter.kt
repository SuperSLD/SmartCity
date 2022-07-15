package online.jutter.smartsity.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import online.jutter.smartsity.databinding.ItemTeamBinding
import online.jutter.smartsity.domain.models.UserLocal

class TeamAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<ParticipantData>()

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
        (holder as TeamViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private inner class TeamViewHolder(private val binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ParticipantData) {

            with(binding) {
                tvName.text = data.user.firstname + " " + data.user.lastname
                tvCaptainFlag.visibility = if (data.isCaptain) View.VISIBLE else View.GONE
            }

        }

    }

    fun addAll(participants: List<UserLocal>, captainId: Long) {
        data.clear()
        data.addAll(participants.map {
            ParticipantData(it, it.id == captainId)
        })
        notifyDataSetChanged()
    }

    private data class ParticipantData(
        val user: UserLocal,
        val isCaptain: Boolean
    )

}
