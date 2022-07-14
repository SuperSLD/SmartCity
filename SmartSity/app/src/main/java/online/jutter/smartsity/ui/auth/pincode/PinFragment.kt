package online.jutter.smartsity.ui.auth.pincode
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_pin.*
import online.jutter.smartsity.R
import online.jutter.smartsity.ui.view.PonyInputView
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopAndBottomPadding

class PinFragment : BaseFragment(R.layout.fragment_pin), MvpView {

    companion object {
        const val ARG_NUMBER = "number"

        fun createInstance(number: String) = PinFragment().apply {
            arguments = Bundle()
            arguments?.putString(ARG_NUMBER, number)
        }
    }

    @InjectPresenter
    lateinit var presenter: PinPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nested.addSystemTopAndBottomPadding()

        icClose.setOnClickListener {
            onBackPressed()
        }

        firstPinView.addTextChangedListener {
            if (it.toString().length == 4) {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}