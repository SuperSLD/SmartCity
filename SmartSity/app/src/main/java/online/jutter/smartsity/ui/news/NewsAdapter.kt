package online.jutter.smartsity.ui.news

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import online.jutter.diffadapter2.DiffAdapter
import online.jutter.diffadapter2.base.HolderFactory
import online.jutter.smartsity.databinding.ItemEventHolderBinding
import online.jutter.smartsity.domain.controllers.models.Event
import online.jutter.smartsity.domain.models.NewsLocal
import online.jutter.supersld.extensions.launchUI
import online.jutter.supersld.extensions.withIO

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val news = mutableListOf<NewsLocal>()

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

    fun addAll(newItems: List<NewsLocal>) {
        news.clear()
        news.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class NewsHolder(private val binding: ItemEventHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: NewsLocal) {
            with(binding) {
                tvTitle.text = data.title
                tvInfo.text = data.shortText
                tvDate.text = data.dateString

                Glide
                    .with(itemView.context)
                    .load(data.image)
                    .into(ivEvent)
            }
        }
    }

}
