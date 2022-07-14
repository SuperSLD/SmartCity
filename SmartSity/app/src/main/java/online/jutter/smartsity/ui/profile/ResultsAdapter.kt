package online.jutter.smartsity.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import online.jutter.smartsity.databinding.ItemResultsBinding

class ResultsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
        (holder as ResultsViewHolder).bind()
    }

    override fun getItemCount(): Int {
        return 0
    }

    inner class ResultsViewHolder(binding: ItemResultsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            //TODO
        }

    }

}
