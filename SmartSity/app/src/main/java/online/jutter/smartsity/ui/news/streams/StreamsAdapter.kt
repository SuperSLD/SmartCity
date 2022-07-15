package online.jutter.smartsity.ui.news.streams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import online.jutter.smartsity.databinding.ItemEventHolderBinding
import online.jutter.smartsity.domain.models.NewsLocal
import online.jutter.smartsity.domain.models.StreamLocal

class StreamsAdapter(private val onStreamClick: (link: String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val news = mutableListOf<StreamLocal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsHolder(
            ItemEventHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsHolder).bind(news[position])
    }

    override fun getItemCount(): Int = news.size

    fun addAll(newItems: List<StreamLocal>) {
        news.clear()
        news.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class NewsHolder(private val binding: ItemEventHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: StreamLocal) {
            with(binding) {
                tvTitle.text = data.name
                tvInfo.text = data.description
                tvDate.visibility = View.INVISIBLE

                Glide
                    .with(itemView.context)
                    .load(data.preview)
                    .into(ivEvent)

                root.setOnClickListener {
                    onStreamClick(data.link)
                }
            }
        }
    }

}
