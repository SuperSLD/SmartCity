package online.jutter.smartsity.ui.news.streams

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.presenter.InjectPresenter
import online.jutter.smartsity.R
import online.jutter.smartsity.common.extesions.openWebLink
import online.jutter.smartsity.databinding.FragmentStreamsBinding
import online.jutter.smartsity.domain.models.StreamLocal
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopAndBottomPadding

class StreamsFragment : BaseFragment(R.layout.fragment_streams), StreamsView {

    @InjectPresenter
    lateinit var presenter: StreamsPresenter

    private val binding: FragmentStreamsBinding by viewBinding()

    private val adapter by lazy { StreamsAdapter(this::openStream) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
    }

    private fun initUi() {
        with(binding) {
            vToolbar.run {
                setTitle("Прямые трансляции")
                onBack({ onBackPressed() }, R.drawable.ic_arrow_left)
            }

            vgContent.addSystemTopAndBottomPadding()

            rvStreams.run {
                adapter = this@StreamsFragment.adapter
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
            }
        }
    }

    fun openStream(link:String) {
        requireContext().openWebLink(link)
    }

    override fun showStreams(streams: List<StreamLocal>) {
        adapter.addAll(streams)
    }

    override fun showErrorLoading() {}

    override fun toggleLoading(show: Boolean) {}

    override fun onBackPressed() { presenter.back() }

}
