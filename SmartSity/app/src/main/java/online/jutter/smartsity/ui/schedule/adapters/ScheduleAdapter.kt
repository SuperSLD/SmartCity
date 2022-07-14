package online.jutter.smartsity.ui.schedule.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import online.jutter.smartsity.databinding.ItemScheduleBinding
import online.jutter.smartsity.domain.models.schedule.ScheduleLocal

class ScheduleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val scheduleList = mutableListOf<ScheduleLocal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ScheduleViewHolder(
            ItemScheduleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ScheduleViewHolder).bind(scheduleList[position])
    }

    override fun getItemCount(): Int = scheduleList.size

    fun addAll(newItems: List<ScheduleLocal>) {
        scheduleList.clear()
        scheduleList.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ScheduleViewHolder(private val binding: ItemScheduleBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ScheduleLocal) {
            with(binding) {
                tvPlace.text = data.place.name
                tvCompetition.text = data.sport.name
            }
        }

    }

}
