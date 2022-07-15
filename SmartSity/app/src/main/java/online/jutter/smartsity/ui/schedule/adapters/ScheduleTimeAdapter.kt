package online.jutter.smartsity.ui.schedule.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import online.jutter.smartsity.databinding.ItemScheduleTimeBinding
import online.jutter.smartsity.domain.models.schedule.ScheduleLocal
import online.jutter.smartsity.domain.models.schedule.ScheduleTimeLocal
import online.jutter.smartsity.ui.ext.SpaceBetweenItemDecoration
import online.jutter.smartsity.ui.ext.dpToPx

class ScheduleTimeAdapter(val onCompetitionClick: (ScheduleLocal)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val scheduleTimeList = mutableListOf<ScheduleTimeLocal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ScheduleTimeViewHolder(
            ItemScheduleTimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ScheduleTimeViewHolder).bind(scheduleTimeList[position])
    }

    override fun getItemCount(): Int = scheduleTimeList.size

    fun addAll(newItems: List<ScheduleTimeLocal>) {
        scheduleTimeList.clear()
        scheduleTimeList.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ScheduleTimeViewHolder(private val binding: ItemScheduleTimeBinding)
        : RecyclerView.ViewHolder(binding.root) {

        private val adapter by lazy { ScheduleAdapter(onCompetitionClick) }

        init {
            with(binding.rvSchedule) {
                adapter = this@ScheduleTimeViewHolder.adapter
                layoutManager = LinearLayoutManager(
                    itemView.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                addItemDecoration(SpaceBetweenItemDecoration(16.dpToPx))
            }
        }

        fun bind(data: ScheduleTimeLocal) {

            with(binding) {
                tvTime.text = data.time
                adapter.addAll(data.scheduleList)
            }

        }

    }

}
