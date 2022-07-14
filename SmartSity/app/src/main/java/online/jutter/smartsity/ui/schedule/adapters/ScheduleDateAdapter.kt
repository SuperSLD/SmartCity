package online.jutter.smartsity.ui.schedule.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import online.jutter.smartsity.databinding.ItemScheduleDateBinding
import online.jutter.smartsity.domain.models.schedule.ScheduleDateLocal
import online.jutter.smartsity.domain.models.schedule.ScheduleLocal
import online.jutter.smartsity.ui.ext.SpaceBetweenItemDecoration
import online.jutter.smartsity.ui.ext.dpToPx

class ScheduleDateAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val scheduleEvents = mutableListOf<ScheduleDateLocal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  ScheduleViewHolder(
            ItemScheduleDateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ScheduleViewHolder).bind(scheduleEvents[position])
    }

    override fun getItemCount(): Int = scheduleEvents.size

    fun addAll(newItems: List<ScheduleDateLocal>) {
        scheduleEvents.clear()
        scheduleEvents.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ScheduleViewHolder(private val binding: ItemScheduleDateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter = ScheduleTimeAdapter()

        init {
            binding.rvSchedule.run {
                adapter = this@ScheduleViewHolder.adapter
                layoutManager = LinearLayoutManager(
                    itemView.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                addItemDecoration(SpaceBetweenItemDecoration(26.dpToPx))
            }
        }

        fun bind(data: ScheduleDateLocal) {

            with(binding) {
                tvDate.text = data.date
                adapter.addAll(data.events)
            }

        }
    }

}
