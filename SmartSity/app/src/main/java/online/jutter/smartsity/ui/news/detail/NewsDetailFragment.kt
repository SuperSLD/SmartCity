package online.jutter.smartsity.ui.news.detail

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import online.jutter.smartsity.R
import online.jutter.smartsity.databinding.FragmentNewsDetailBinding
import online.jutter.smartsity.domain.models.NewsLocal
import online.jutter.supersld.common.base.BaseFragment

class NewsDetailFragment : BaseFragment(R.layout.fragment_news_detail), NewsDetailsView {

    @InjectPresenter
    lateinit var presenter: NewsDetailPresenter

    @ProvidePresenter
    fun providePresenter() = NewsDetailPresenter(
        arguments?.getParcelable(ARG_NEWS)
    )

    private val binding: FragmentNewsDetailBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        with(binding) {
            btnBack.setOnClickListener {
                onBackPressed()
            }
        }
    }

    override fun showNewsDetail(data: NewsLocal) {
        with(binding) {
            tvTitle.text = data.title
            tvText.text = data.text
            tvDate.text = data.dateString

            Glide
                .with(requireContext())
                .load(data.image)
                .into(ivImage)
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }

    companion object {

        private const val ARG_NEWS = "arg_news"

        fun create(news: NewsLocal): NewsDetailFragment {

            val fragment = NewsDetailFragment()
            val args = Bundle()

            args.putParcelable(ARG_NEWS, news)

            fragment.arguments = args

            return fragment
        }

    }

}
