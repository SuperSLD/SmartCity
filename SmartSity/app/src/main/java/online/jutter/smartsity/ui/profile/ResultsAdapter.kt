package online.jutter.smartsity.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import online.jutter.smartsity.R
import online.jutter.smartsity.databinding.ItemResultsBinding

class ResultsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val results = mutableListOf<Int?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ResultsViewHolder(
            ItemResultsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ResultsViewHolder).bind(results[position], position)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    fun addAll(gold: Int?, silver: Int?, bronze: Int?, other: Int?) {
        results.clear()
        results.addAll(listOf(gold, silver, bronze, other))
        notifyDataSetChanged()
    }

    private inner class ResultsViewHolder(private val binding: ItemResultsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(medalsCount: Int?, position: Int) {
            with(binding) {
                tvMedalsCount.text = if (medalsCount == 0 || medalsCount == null) "---"
                    else medalsCount.toString()

                val filledMedal = ContextCompat.getDrawable(itemView.context, R.drawable.bg_medal)
                val emptyMedal = ContextCompat.getDrawable(itemView.context, R.drawable.bg_medal_empty)
                when (position) {
                    0 -> {
                        tvPlace.text = itemView.context.getString(R.string.profile_medal_gold)
                        ivMedal.setImageDrawable(filledMedal)
                        ivMedal.drawable.mutate().setTint(
                            ContextCompat.getColor(itemView.context, R.color.colorMedalGold)
                        )
                    }
                    1 -> {
                        tvPlace.text = itemView.context.getString(R.string.profile_medal_silver)
                        ivMedal.setImageDrawable(filledMedal)
                        ivMedal.drawable.mutate().setTint(
                            ContextCompat.getColor(itemView.context, R.color.colorMedalSilver)
                        )
                    }
                    2 -> {
                        tvPlace.text = itemView.context.getString(R.string.profile_medal_bronze)
                        ivMedal.setImageDrawable(filledMedal)
                        ivMedal.drawable.setTint(
                            ContextCompat.getColor(itemView.context, R.color.colorMedalBronze)
                        )
                    }
                    else -> {
                        tvPlace.text = itemView.context.getString(R.string.profile_medal_other)
                        ivMedal.setImageDrawable(emptyMedal)
                    }
                }
            }
        }

    }

}
