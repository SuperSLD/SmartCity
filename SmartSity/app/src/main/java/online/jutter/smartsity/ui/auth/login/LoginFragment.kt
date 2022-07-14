package online.jutter.smartsity.ui.auth.login
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_login.*
import online.jutter.smartsity.R
import online.jutter.smartsity.ui.view.PonyInputView
import online.jutter.supersld.common.base.BaseFragment

class LoginFragment : BaseFragment(R.layout.fragment_login), MvpView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    private var number = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.isEnabled = false

        with(inPhone) {
            showTitle(R.string.auth_number)
            setPrefix("+7")
            setDigits("0123456789()-+ ")
            setImeAction(PonyInputView.ImeAction(EditorInfo.IME_ACTION_DONE) {

            })
            setTextMask("([000]) [000]-[00]-[00]")
            onValidChange { b, s, s2 ->
                btnLogin.isEnabled = b
                number = s
            }
        }

        btnLogin.setOnClickListener {
            presenter.onLogin(number)
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}